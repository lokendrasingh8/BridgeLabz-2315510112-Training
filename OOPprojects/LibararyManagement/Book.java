package LibraryManagement;

public class Book extends LibraryItem implements Reservable {
    private boolean available = true;

    public Book(String id, String title, String author) { super(id, title, author); }

    @Override
    public int getLoanDuration() { return 14; }

    @Override
    public boolean reserveItem(String userId) {
        if (available) {
            available = false;
            return true;
        }
        return false;
    }

    @Override
    public boolean checkAvailability() { return available; }
}
