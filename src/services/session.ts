import IORedis from 'ioredis';
import { Redis } from '@upstash/redis';
import { CartItem, UserSession } from '../config/types.js';

let ioRedis: IORedis | null = null;
let upstash: Redis | null = null;

const memory = new Map<string, UserSession>();

function getRedis() {
  if (process.env.UPSTASH_REDIS_REST_URL && process.env.UPSTASH_REDIS_REST_TOKEN) {
    if (!upstash) {
      upstash = new Redis({
        url: process.env.UPSTASH_REDIS_REST_URL!,
        token: process.env.UPSTASH_REDIS_REST_TOKEN!,
      });
    }
    return { type: 'upstash' as const, client: upstash };
  }
  if (process.env.REDIS_URL) {
    if (!ioRedis) ioRedis = new IORedis(process.env.REDIS_URL);
    return { type: 'ioredis' as const, client: ioRedis };
  }
  return { type: 'memory' as const, client: null };
}

const TTL_SECONDS = 60 * 60 * 12;

export async function getSession(userId: string): Promise<UserSession> {
  const key = `wa:sess:${userId}`;
  const redis = getRedis();
  if (redis.type === 'upstash') {
    const raw = await redis.client!.get<UserSession>(key);
    if (raw) return raw;
  } else if (redis.type === 'ioredis') {
    const raw = await (redis.client as IORedis).get(key);
    if (raw) return JSON.parse(raw);
  } else {
    const raw = memory.get(key);
    if (raw) return raw;
  }
  const empty: UserSession = { userId, cart: [], updatedAt: Date.now() };
  await saveSession(empty);
  return empty;
}

export async function saveSession(session: UserSession): Promise<void> {
  const key = `wa:sess:${session.userId}`;
  session.updatedAt = Date.now();
  const redis = getRedis();
  if (redis.type === 'upstash') {
    await redis.client!.set(key, session, { ex: TTL_SECONDS });
  } else if (redis.type === 'ioredis') {
    await (redis.client as IORedis).set(key, JSON.stringify(session), 'EX', TTL_SECONDS);
  } else {
    memory.set(key, session);
  }
}

export function addToCart(session: UserSession, item: CartItem): UserSession {
  const existing = session.cart.find(
    (c) => c.productId === item.productId && c.priceMinor === item.priceMinor,
  );
  if (existing) {
    existing.quantity += item.quantity;
  } else {
    session.cart.push(item);
  }
  return session;
}

export function formatCartTotal(session: UserSession): number {
  return session.cart.reduce((sum, c) => sum + c.priceMinor * c.quantity, 0);
}
