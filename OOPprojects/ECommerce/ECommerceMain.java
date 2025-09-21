package ECommerce;
import java.util.*;

public class ECommerceMain {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Electronics("E001", "Smartphone", 20000));
        products.add(new Clothing("C001", "Jeans", 1500));
        products.add(new Groceries("G001", "Rice 5kg", 400));

        for (Product p : products) {
            double discount = p.calculateDiscount();
            double tax = (p instanceof Taxable) ? ((Taxable)p).calculateTax() : 0;
            double finalPrice = p.getPrice() + tax - discount;
            System.out.println(p + ", Discount=" + discount + ", Tax=" + tax + ", FinalPrice=" + finalPrice);
        }
    }
}
