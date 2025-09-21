package LibraryManagement;

public class DVD extends LibraryItem {
    public DVD(String id, String title, String author) { super(id, title, author); }

    @Override
    public int getLoanDuration() { return 3; }
}
