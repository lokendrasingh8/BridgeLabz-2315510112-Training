import express from 'express';
import twilio from 'twilio';
import { detectIntent } from '../nlp/intent.js';
import { getSession, saveSession, addToCart } from '../services/session.js';
import { searchProducts } from '../services/search.js';
import { formatCart, formatRupees, formatSearchResults } from '../format/whatsapp.js';
export const whatsappRouter = express.Router();
whatsappRouter.post('/', async (req, res) => {
    const twiml = new twilio.twiml.MessagingResponse();
    const from = String(req.body.From || '');
    const body = String(req.body.Body || '').trim();
    if (!from.startsWith('whatsapp:')) {
        twiml.message('Please message from WhatsApp.');
        return res.type('text/xml').send(twiml.toString());
    }
    const userId = from;
    const session = await getSession(userId);
    const intent = await detectIntent(body);
    switch (intent.type) {
        case 'help': {
            twiml.message(helpText());
            break;
        }
        case 'view_cart': {
            const text = formatCart(session);
            twiml.message(text);
            break;
        }
        case 'checkout': {
            if (session.cart.length === 0) {
                twiml.message('Your cart is empty. Search for a product to begin.');
            }
            else {
                const links = session.cart.map((c) => `• ${c.name} — visit provider link to buy`);
                twiml.message('For checkout, open the product links from search results and add to cart there. Payments via WhatsApp are not enabled in this demo.\n' +
                    links.join('\n'));
            }
            break;
        }
        case 'add_to_cart': {
            const lastQuery = session.lastIntent?.type === 'search' ? session.lastIntent.query : null;
            if (!lastQuery) {
                twiml.message('Please search first, then reply "add <number>".');
                break;
            }
            const products = await searchProducts(lastQuery);
            const idx = intent.index - 1;
            if (idx < 0 || idx >= Math.min(5, products.length)) {
                twiml.message('Invalid item number. Reply with a number from the list.');
                break;
            }
            const chosen = products[idx];
            const priceMinor = chosen.bestPriceMinor;
            const item = {
                productId: chosen.id,
                name: chosen.name,
                priceMinor,
                currency: chosen.currency,
                quantity: 1,
            };
            addToCart(session, item);
            await saveSession(session);
            twiml.message(`Added to cart: ${chosen.name} — ${formatRupees(priceMinor)}`);
            break;
        }
        case 'search': {
            const products = await searchProducts(intent.query);
            session.lastIntent = intent;
            await saveSession(session);
            const text = formatSearchResults(products);
            twiml.message(text);
            break;
        }
        default: {
            twiml.message('Sorry, I did not understand. Type "help" for commands.');
        }
    }
    res.type('text/xml').send(twiml.toString());
});
function helpText() {
    return [
        'Welcome to the AI Shopping Assistant! 🛍️',
        '• Search: send what you want (e.g., "iPhone 14 128GB")',
        '• Add to cart: reply "add 1" based on the list number',
        '• View your cart: type "cart"',
        '• Checkout: type "checkout"',
    ].join('\n');
}
