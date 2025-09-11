class Book {
    static String libraryName = "City Library";

    final String isbn;
    String title, author;

    Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    static void displayLibraryName() {
        System.out.println("Library: " + libraryName);
    }

    void displayBookDetails() {
        if (this instanceof Book) {
            System.out.println("Title: " + title + ", Author: " + author + ", ISBN: " + isbn);
        }
    }
}
