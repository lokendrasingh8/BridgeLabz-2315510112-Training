class Book {
    private String title;
    private String author;
    private double price;

    // Default Constructor
    public Book() {
        this("Unknown", "Unknown", 0.0);
    }

    // Parameterized Constructor
    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    void display() {
        System.out.println(title + " by " + author + " $" + price);
    }
}
