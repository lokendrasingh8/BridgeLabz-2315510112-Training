import express from 'express';
import { loadEnv } from './utils/env.js';
import { logger } from './utils/logger.js';
import { whatsappRouter } from './webhooks/whatsapp.js';
loadEnv();
const app = express();
app.use(express.urlencoded({ extended: true }));
app.use(express.json());
app.get('/', (_req, res) => {
    res.send('AI WhatsApp Shopping Bot is running');
});
app.use('/webhooks/whatsapp', whatsappRouter);
const PORT = process.env.PORT || 3000;
app.listen(PORT, () => {
    logger.info({ port: PORT }, 'Server listening');
});
