package FoodDelivery;
import java.util.*;

public class FoodMain {
    public static void main(String[] args) {
        List<FoodItem> order = new ArrayList<>();
        order.add(new VegItem("Paneer Curry", 200, 2));
        order.add(new NonVegItem("Chicken Biryani", 250, 1));

        double total = 0;
        for (FoodItem f : order) {
            double price = f.calculateTotalPrice();
            double discount = (f instanceof Discountable) ? ((Discountable)f).applyDiscount() : 0;
            System.out.println(f.getItemDetails() + ", Discount=" + discount);
            total += price - discount;
        }
        System.out.println("Order Total: " + total);
    }
}
