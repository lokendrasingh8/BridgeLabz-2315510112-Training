import { searchSerpApiProducts } from '../providers/serpapi.js';
import { searchAmazon } from '../providers/amazon.js';
import { searchFlipkart } from '../providers/flipkart.js';
export async function searchProducts(query) {
    const [serp, amz, flip] = await Promise.all([
        searchSerpApiProducts(query),
        searchAmazon(query),
        searchFlipkart(query),
    ]);
    const merged = [...serp, ...amz, ...flip];
    const dedup = new Map();
    for (const p of merged) {
        if (!dedup.has(p.id)) {
            dedup.set(p.id, p);
        }
        else {
            const existing = dedup.get(p.id);
            const best = p.bestPriceMinor < existing.bestPriceMinor ? p.bestPriceMinor : existing.bestPriceMinor;
            dedup.set(p.id, {
                ...existing,
                bestPriceMinor: best,
                offers: [...existing.offers, ...p.offers],
            });
        }
    }
    return Array.from(dedup.values()).sort((a, b) => a.bestPriceMinor - b.bestPriceMinor);
}
