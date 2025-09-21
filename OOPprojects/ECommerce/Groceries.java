package ECommerce;

public class Groceries extends Product {
    public Groceries(String id, String name, double price) {
        super(id, name, price);
    }

    @Override
    public double calculateDiscount() {
        // small discount on groceries
        return getPrice() * 0.05;
    }
}
