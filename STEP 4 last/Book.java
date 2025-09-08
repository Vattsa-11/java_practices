// Problem 3: Library Book Management
public class Book {
    String title;
    String author;
    String isbn;
    boolean isAvailable;

    // Default constructor
    public Book() {
        this("", "", "", true);
    }
    // Constructor with title and author
    public Book(String title, String author) {
        this(title, author, "", true);
    }
    // Constructor with all details
    public Book(String title, String author, String isbn, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isAvailable = isAvailable;
    }
    public void borrowBook() {
        isAvailable = false;
    }
    public void returnBook() {
        isAvailable = true;
    }
    public void displayBookInfo() {
        System.out.printf("Title: %s | Author: %s | ISBN: %s | Available: %b\n", title, author, isbn, isAvailable);
    }
    public static void main(String[] args) {
        Book b1 = new Book();
        Book b2 = new Book("1984", "George Orwell");
        Book b3 = new Book("Java", "James Gosling", "12345", true);
        b2.borrowBook();
        b3.returnBook();
        b1.displayBookInfo();
        b2.displayBookInfo();
        b3.displayBookInfo();
    }
}
