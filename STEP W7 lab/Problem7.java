// Problem 7: E-Commerce Recommendation Engine - Multiple Polymorphism Integration
import java.util.*;

abstract class Product {
    protected String name;
    protected double price;
    protected String category;
    protected double rating;
    
    public Product(String name, double price, String category, double rating) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.rating = rating;
    }
    
    // Abstract method for custom recommendations (to be overridden)
    public abstract void recommend();
    
    // Method overloading for different update types
    public void updateProduct(double newPrice) {
        this.price = newPrice;
        System.out.println("Price updated for " + name + " to $" + newPrice);
    }
    
    public void updateProduct(double newPrice, double newRating) {
        this.price = newPrice;
        this.rating = newRating;
        System.out.println("Price and rating updated for " + name);
    }
    
    public void updateProduct(String newName, double newPrice, double newRating) {
        this.name = newName;
        this.price = newPrice;
        this.rating = newRating;
        System.out.println("Complete product info updated");
    }
    
    public void displayBasicInfo() {
        System.out.println("Product: " + name + " | Price: $" + price + " | Rating: " + rating + "/5");
    }
}

class Electronics extends Product {
    private int warrantyYears;
    private String processor;
    private String brand;
    
    public Electronics(String name, double price, double rating, int warrantyYears, String processor, String brand) {
        super(name, price, "Electronics", rating);
        this.warrantyYears = warrantyYears;
        this.processor = processor;
        this.brand = brand;
    }
    
    @Override
    public void recommend() {
        System.out.println("📱 Electronics Recommendation for " + name + ":");
        System.out.println("   ✓ " + warrantyYears + " year warranty included");
        System.out.println("   ✓ Features " + processor + " processor");
        System.out.println("   ✓ Brand: " + brand);
        System.out.println("   ✓ Similar tech products you might like based on specs");
    }
    
    public void showTechSpecs() {
        System.out.println("Tech Specs - Processor: " + processor + ", Warranty: " + warrantyYears + " years");
    }
}

class Clothing extends Product {
    private String[] availableSizes;
    private String material;
    private String style;
    
    public Clothing(String name, double price, double rating, String[] sizes, String material, String style) {
        super(name, price, "Clothing", rating);
        this.availableSizes = sizes;
        this.material = material;
        this.style = style;
    }
    
    @Override
    public void recommend() {
        System.out.println("👔 Fashion Recommendation for " + name + ":");
        System.out.println("   ✓ Available sizes: " + Arrays.toString(availableSizes));
        System.out.println("   ✓ Material: " + material);
        System.out.println("   ✓ Style: " + style);
        System.out.println("   ✓ Matching outfits and accessories suggested");
    }
    
    public void showSizeChart() {
        System.out.println("Size Chart - Available: " + Arrays.toString(availableSizes) + ", Material: " + material);
    }
}

class Book extends Product {
    private String author;
    private String genre;
    private int pages;
    
    public Book(String name, double price, double rating, String author, String genre, int pages) {
        super(name, price, "Books", rating);
        this.author = author;
        this.genre = genre;
        this.pages = pages;
    }
    
    @Override
    public void recommend() {
        System.out.println("📚 Book Recommendation for " + name + ":");
        System.out.println("   ✓ By author: " + author);
        System.out.println("   ✓ Genre: " + genre + " (" + pages + " pages)");
        System.out.println("   ✓ Other books by " + author + " you might enjoy");
        System.out.println("   ✓ Similar " + genre + " books recommended");
    }
    
    public void showAuthorDetails() {
        System.out.println("Author Details - " + author + ", Genre: " + genre + ", Pages: " + pages);
    }
}

public class Problem7 {
    public static void main(String[] args) {
        System.out.println("=== E-Commerce Recommendation Engine ===\n");
        
        // Create different product types
        List<Product> catalog = new ArrayList<>();
        catalog.add(new Electronics("iPhone 15", 999.99, 4.5, 2, "A17 Pro", "Apple"));
        catalog.add(new Clothing("Designer Jeans", 89.99, 4.2, new String[]{"S", "M", "L", "XL"}, "Denim", "Casual"));
        catalog.add(new Book("Java Programming", 49.99, 4.8, "James Gosling", "Programming", 650));
        catalog.add(new Electronics("Gaming Laptop", 1299.99, 4.7, 3, "Intel i7", "ASUS"));
        catalog.add(new Book("The Great Gatsby", 12.99, 4.6, "F. Scott Fitzgerald", "Classic Literature", 180));
        
        System.out.println("=== Product Recommendations (Method Overriding) ===");
        for (Product product : catalog) {
            product.displayBasicInfo();
            product.recommend(); // Different behavior based on actual object type
            System.out.println();
        }
        
        System.out.println("=== Product Updates (Method Overloading) ===");
        Product phone = catalog.get(0);
        
        // Different ways to update product (method overloading)
        phone.updateProduct(899.99); // Update price only
        phone.updateProduct(899.99, 4.6); // Update price and rating
        phone.updateProduct("iPhone 15 Pro", 1099.99, 4.7); // Update everything
        System.out.println();
        
        System.out.println("=== Safe Product Processing (Downcasting with instanceof) ===");
        for (Product product : catalog) {
            System.out.println("Processing: " + product.name);
            
            // Safe downcasting to access specific features
            if (product instanceof Electronics) {
                Electronics electronics = (Electronics) product;
                electronics.showTechSpecs();
            } else if (product instanceof Clothing) {
                Clothing clothing = (Clothing) product;
                clothing.showSizeChart();
            } else if (product instanceof Book) {
                Book book = (Book) product;
                book.showAuthorDetails();
            }
            System.out.println();
        }
        
        System.out.println("=== Mixed Catalog Processing Demo ===");
        // Demonstrate handling mixed types safely
        Product[] mixedProducts = {
            new Electronics("Smart Watch", 299.99, 4.3, 1, "Snapdragon", "Samsung"),
            new Book("Clean Code", 35.99, 4.9, "Robert Martin", "Programming", 464),
            new Clothing("Leather Jacket", 199.99, 4.4, new String[]{"M", "L", "XL"}, "Leather", "Biker")
        };
        
        for (Product p : mixedProducts) {
            p.recommend(); // Polymorphic behavior
            System.out.println("---");
        }
    }
}