import OpenAI from 'openai';
import { DetectedIntent } from '../config/types.js';

const systemPrompt = `You are an intent parser for a WhatsApp shopping assistant.
Return strict JSON with one of the following shapes:
{"type":"search","query":"..."}
{"type":"add_to_cart","index":1}
{"type":"view_cart"}
{"type":"checkout"}
{"type":"help"}
`;

export async function detectIntent(text: string): Promise<DetectedIntent> {
  const apiKey = process.env.OPENAI_API_KEY;
  if (!apiKey) {
    return regexFallback(text);
  }
  try {
    const client = new OpenAI({ apiKey });
    const completion = await client.chat.completions.create({
      model: 'gpt-4o-mini',
      temperature: 0,
      messages: [
        { role: 'system', content: systemPrompt },
        { role: 'user', content: text }
      ],
      response_format: { type: 'json_object' }
    });
    const content = completion.choices[0]?.message?.content ?? '';
    const parsed = JSON.parse(content);
    if (parsed && parsed.type) {
      return parsed as DetectedIntent;
    }
    return regexFallback(text);
  } catch {
    return regexFallback(text);
  }
}

function regexFallback(text: string): DetectedIntent {
  const t = text.trim();
  if (/^(help|menu)$/i.test(t)) return { type: 'help' };
  if (/^(cart|view cart)$/i.test(t)) return { type: 'view_cart' };
  if (/^(checkout|buy now)$/i.test(t)) return { type: 'checkout' };

  const addMatch = t.match(/add\s*(\d+)/i);
  if (addMatch) return { type: 'add_to_cart', index: Number(addMatch[1]) };

  return { type: 'search', query: t };
}
