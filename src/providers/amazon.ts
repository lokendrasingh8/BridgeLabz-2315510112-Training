// Placeholder for optional Amazon direct provider via affiliate APIs or scraping proxies.
// For hackathon readiness, keep disabled by default to avoid TOS issues.
import { NormalizedProduct } from '../config/types.js';

export async function searchAmazon(_query: string): Promise<NormalizedProduct[]> {
  return [];
}
