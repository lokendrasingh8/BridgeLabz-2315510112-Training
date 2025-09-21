package LibraryManagement;
import java.util.*;

public class LibraryMain {
    public static void main(String[] args) {
        List<LibraryItem> items = new ArrayList<>();
        items.add(new Book("B001", "Effective Java", "Joshua Bloch"));
        items.add(new Magazine("M001", "Tech Monthly", "Editorial"));
        items.add(new DVD("D001", "Inception", "Christopher Nolan"));

        for (LibraryItem it : items) {
            System.out.println(it.getItemDetails() + ", Loan days: " + it.getLoanDuration());
            if (it instanceof Reservable) {
                System.out.println("Reservable: " + ((Reservable)it).checkAvailability());
            }
            System.out.println("---");
        }
    }
}
