package ECommerce;

public class Clothing extends Product implements Taxable {
    public Clothing(String id, String name, double price) {
        super(id, name, price);
    }

    @Override
    public double calculateDiscount() {
        // 20% discount on clothing
        return getPrice() * 0.20;
    }

    @Override
    public double calculateTax() {
        // 12% tax
        return getPrice() * 0.12;
    }

    @Override
    public String getTaxDetails() {
        return "Tax 12%";
    }
}
