package ECommerce;

public class Electronics extends Product implements Taxable {
    public Electronics(String id, String name, double price) {
        super(id, name, price);
    }

    @Override
    public double calculateDiscount() {
        // 10% discount on electronics
        return getPrice() * 0.10;
    }

    @Override
    public double calculateTax() {
        // 18% GST example
        return getPrice() * 0.18;
    }

    @Override
    public String getTaxDetails() {
        return "GST 18%";
    }
}
