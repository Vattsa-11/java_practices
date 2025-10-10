class Book {
    private String title;
    private String author;
    
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
    
    // Override equals() method to compare based on title and author
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Book book = (Book) obj;
        return title.equals(book.title) && author.equals(book.author);
    }
    
    @Override
    public String toString() {
        return "Book{title='" + title + "', author='" + author + "'}";
    }
}

public class Lab1_BookComparison {
    public static void main(String[] args) {
        // Create two Book objects with same content
        Book book1 = new Book("Java Programming", "John Doe");
        Book book2 = new Book("Java Programming", "John Doe");
        
        // Create a third Book object with different content
        Book book3 = new Book("Python Programming", "Jane Smith");
        
        // Create a reference to book1
        Book book4 = book1;
        
        System.out.println("book1: " + book1);
        System.out.println("book2: " + book2);
        System.out.println("book3: " + book3);
        System.out.println("book4: " + book4);
        
        System.out.println("\n--- Comparing using == (Reference Comparison) ---");
        System.out.println("book1 == book2: " + (book1 == book2)); // false (different objects)
        System.out.println("book1 == book3: " + (book1 == book3)); // false
        System.out.println("book1 == book4: " + (book1 == book4)); // true (same reference)
        
        System.out.println("\n--- Comparing using .equals() (Content Comparison) ---");
        System.out.println("book1.equals(book2): " + book1.equals(book2)); // true (same content)
        System.out.println("book1.equals(book3): " + book1.equals(book3)); // false (different content)
        System.out.println("book1.equals(book4): " + book1.equals(book4)); // true (same reference & content)
        
        System.out.println("\n--- Key Difference ---");
        System.out.println("== checks if both references point to the same object in memory");
        System.out.println(".equals() checks if the content of the objects is the same");
    }
}
