package FoodDelivery;

public class NonVegItem extends FoodItem implements Discountable {
    public NonVegItem(String name, double price, int qty) { super(name, price, qty); }

    @Override
    public double calculateTotalPrice() {
        // add small non-veg surcharge per item
        return (getPrice() + 20) * getQuantity();
    }

    @Override
    public double applyDiscount() {
        return calculateTotalPrice() * 0.03; // 3% discount
    }

    @Override
    public String getDiscountDetails() { return "Non-veg surcharge 20 per item, discount 3%"; }
}
