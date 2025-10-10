export function formatRupees(minor) {
    const rupees = minor / 100;
    return `₹${rupees.toLocaleString('en-IN', { maximumFractionDigits: 2 })}`;
}
export function formatSearchResults(products) {
    if (products.length === 0) {
        return 'No products found. Try a different query or be more specific.';
    }
    const lines = [];
    lines.push('Top results:');
    products.slice(0, 5).forEach((p, idx) => {
        const price = formatRupees(p.bestPriceMinor);
        const primaryUrl = p.offers[0]?.productUrl ? `\n   ${p.offers[0].productUrl}` : '';
        lines.push(`${idx + 1}. ${p.name}\n   ${price} • ${p.offers.length} offer(s)${primaryUrl}`);
    });
    lines.push('Reply with "add <number>" to add to cart.');
    lines.push('Type "cart" to view cart, "checkout" to proceed, or "help".');
    return lines.join('\n');
}
export function formatCart(session) {
    if (session.cart.length === 0)
        return 'Your cart is empty. Search for products to add items.';
    const lines = [];
    lines.push('Your cart:');
    session.cart.forEach((c, idx) => {
        lines.push(`${idx + 1}. ${c.name} x${c.quantity} — ${formatRupees(c.priceMinor)}`);
    });
    const total = session.cart.reduce((sum, c) => sum + c.priceMinor * c.quantity, 0);
    lines.push(`Total: ${formatRupees(total)}`);
    lines.push('Type "checkout" to proceed to merchant site(s).');
    return lines.join('\n');
}
