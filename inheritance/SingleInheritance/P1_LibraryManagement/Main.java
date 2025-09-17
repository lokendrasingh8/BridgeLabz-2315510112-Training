
// Single Inheritance - Problem 1: Library Management
class Book {
    String title;
    int publicationYear;

    Book(String title, int publicationYear) {
        this.title = title;
        this.publicationYear = publicationYear;
    }
}

class Author extends Book {
    String name;
    String bio;

    Author(String title, int publicationYear, String name, String bio) {
        super(title, publicationYear);
        this.name = name;
        this.bio = bio;
    }

    void displayInfo() {
        System.out.println("Book: " + title + " (" + publicationYear + ")");
        System.out.println("Author: " + name + " - " + bio);
    }
}

public class Main {
    public static void main(String[] args) {
        Author author = new Author("Java Basics", 2023, "John Doe", "Tech Writer");
        author.displayInfo();
    }
}
