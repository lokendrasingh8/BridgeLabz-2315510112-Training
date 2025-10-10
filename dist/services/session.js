import IORedis from 'ioredis';
import { Redis } from '@upstash/redis';
let ioRedis = null;
let upstash = null;
const memory = new Map();
function getRedis() {
    if (process.env.UPSTASH_REDIS_REST_URL && process.env.UPSTASH_REDIS_REST_TOKEN) {
        if (!upstash) {
            upstash = new Redis({
                url: process.env.UPSTASH_REDIS_REST_URL,
                token: process.env.UPSTASH_REDIS_REST_TOKEN,
            });
        }
        return { type: 'upstash', client: upstash };
    }
    if (process.env.REDIS_URL) {
        if (!ioRedis)
            ioRedis = new IORedis(process.env.REDIS_URL);
        return { type: 'ioredis', client: ioRedis };
    }
    return { type: 'memory', client: null };
}
const TTL_SECONDS = 60 * 60 * 12;
export async function getSession(userId) {
    const key = `wa:sess:${userId}`;
    const redis = getRedis();
    if (redis.type === 'upstash') {
        const raw = await redis.client.get(key);
        if (raw)
            return raw;
    }
    else if (redis.type === 'ioredis') {
        const raw = await redis.client.get(key);
        if (raw)
            return JSON.parse(raw);
    }
    else {
        const raw = memory.get(key);
        if (raw)
            return raw;
    }
    const empty = { userId, cart: [], updatedAt: Date.now() };
    await saveSession(empty);
    return empty;
}
export async function saveSession(session) {
    const key = `wa:sess:${session.userId}`;
    session.updatedAt = Date.now();
    const redis = getRedis();
    if (redis.type === 'upstash') {
        await redis.client.set(key, session, { ex: TTL_SECONDS });
    }
    else if (redis.type === 'ioredis') {
        await redis.client.set(key, JSON.stringify(session), 'EX', TTL_SECONDS);
    }
    else {
        memory.set(key, session);
    }
}
export function addToCart(session, item) {
    const existing = session.cart.find((c) => c.productId === item.productId && c.priceMinor === item.priceMinor);
    if (existing) {
        existing.quantity += item.quantity;
    }
    else {
        session.cart.push(item);
    }
    return session;
}
export function formatCartTotal(session) {
    return session.cart.reduce((sum, c) => sum + c.priceMinor * c.quantity, 0);
}
