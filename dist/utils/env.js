import { config } from 'dotenv';
import { z } from 'zod';
export function loadEnv() {
    config();
    const schema = z.object({
        PORT: z.string().optional(),
        OPENAI_API_KEY: z.string().min(1),
        SERPAPI_API_KEY: z.string().min(1),
        TWILIO_ACCOUNT_SID: z.string().min(1),
        TWILIO_AUTH_TOKEN: z.string().min(1),
        TWILIO_WHATSAPP_NUMBER: z.string().min(1),
        REDIS_URL: z.string().optional(),
        UPSTASH_REDIS_REST_URL: z.string().optional(),
        UPSTASH_REDIS_REST_TOKEN: z.string().optional()
    });
    const parsed = schema.safeParse(process.env);
    if (!parsed.success) {
        // Print readable error for missing variables
        // eslint-disable-next-line no-console
        console.error('Invalid or missing environment variables:', parsed.error.flatten().fieldErrors);
        throw new Error('ENV_VALIDATION_FAILED');
    }
}
