package ECommerce;

public abstract class Product {
    private String productId;
    private String name;
    private double price;

    public Product(String productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public String getProductId() { return productId; }
    public String getName() { return name; }
    public double getPrice() { return price; }

    public void setPrice(double price) { this.price = price; }

    public abstract double calculateDiscount();

    public String toString() {
        return name + " (" + productId + ") - " + price;
    }
}
