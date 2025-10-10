import { getJson } from 'serpapi';
import crypto from 'node:crypto';
export async function searchSerpApiProducts(query) {
    const apiKey = process.env.SERPAPI_API_KEY;
    const params = {
        engine: 'google_shopping',
        q: query,
        api_key: apiKey,
        gl: 'in',
        hl: 'en',
        google_domain: 'google.co.in'
    };
    const json = await getJson(params);
    const shoppingResults = json.shopping_results;
    if (!shoppingResults || shoppingResults.length === 0)
        return [];
    const products = shoppingResults.slice(0, 10).map((item) => {
        const offers = [
            {
                provider: 'serpapi',
                title: item.title,
                price: toMinor(parsePrice(item.extracted_price, item.price)),
                currency: 'INR',
                productUrl: item.link,
                imageUrl: item.thumbnail,
                rating: item.rating,
                ratingCount: item.reviews ? Number(String(item.reviews).replace(/\D/g, '')) : undefined,
                deliveryEstimate: item.delivery
            }
        ];
        const id = crypto
            .createHash('sha256')
            .update(`serpapi|${item.link}`)
            .digest('hex')
            .slice(0, 16);
        return {
            id,
            name: item.title,
            bestPriceMinor: offers[0].price,
            currency: 'INR',
            offers
        };
    });
    return products;
}
function toMinor(price) {
    const v = Number(price ?? 0);
    return Math.round(v * 100);
}
function parsePrice(extracted, raw) {
    if (typeof extracted === 'number')
        return extracted;
    if (typeof raw === 'string') {
        const match = raw.replace(/,/g, '').match(/([0-9]+(?:\.[0-9]+)?)/);
        if (match)
            return Number(match[1]);
    }
    return null;
}
