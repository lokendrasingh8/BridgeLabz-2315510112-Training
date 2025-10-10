export type Currency = 'INR' | 'USD';

export interface ProductOffer {
  provider: 'serpapi' | 'amazon' | 'flipkart';
  title: string;
  price: number; // minor units (paise)
  currency: Currency;
  productUrl: string;
  imageUrl?: string;
  rating?: number;
  ratingCount?: number;
  deliveryEstimate?: string;
}

export interface NormalizedProduct {
  id: string; // stable hash from provider+url
  name: string;
  bestPriceMinor: number;
  currency: Currency;
  offers: ProductOffer[];
}

export interface UserSession {
  userId: string; // e.g., whatsapp:+91...
  cart: CartItem[];
  lastIntent?: DetectedIntent;
  updatedAt: number;
}

export interface CartItem {
  productId: string;
  name: string;
  priceMinor: number;
  currency: Currency;
  quantity: number;
}

export type DetectedIntent =
  | { type: 'search'; query: string }
  | { type: 'add_to_cart'; index: number }
  | { type: 'view_cart' }
  | { type: 'checkout' }
  | { type: 'help' }
  | { type: 'unknown'; text: string };
