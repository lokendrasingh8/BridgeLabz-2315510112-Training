class HotelBooking {
    private String guestName;
    private String roomType;
    private int nights;

    // Default
    public HotelBooking() {
        this("Guest", "Standard", 1);
    }

    // Parameterized
    public HotelBooking(String guestName, String roomType, int nights) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.nights = nights;
    }

    // Copy Constructor
    public HotelBooking(HotelBooking other) {
        this(other.guestName, other.roomType, other.nights);
    }

    void display() {
        System.out.println(guestName + " booked " + roomType + " for " + nights + " nights.");
    }
}
