package LibraryManagement;

public interface Reservable {
    boolean reserveItem(String userId);
    boolean checkAvailability();
}
