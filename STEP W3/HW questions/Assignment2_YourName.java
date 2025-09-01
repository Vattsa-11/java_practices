/**
 * Assignment 2: Online Shopping Cart System
 * Author: YourName
 * Date: 2025-09-01
 *
 * Simple shopping cart system demonstrating OOP concepts and object relationships.
 */
class Product {
    private String productId;
    private String productName;
    private double price;
    private String category;
    private int stockQuantity;


    public Product(String id, String name, double price, String category, int stock) {
        this.productId = id;
        this.productName = name;
        this.price = price;
        this.category = category;
        this.stockQuantity = stock;
    }

    public String getProductId() { return productId; }
    public String getProductName() { return productName; }
    public double getPrice() { return price; }
    public String getCategory() { return category; }
    public int getStockQuantity() { return stockQuantity; }
    public void reduceStock(int qty) { if (qty <= stockQuantity) stockQuantity -= qty; }
    public void increaseStock(int qty) { stockQuantity += qty; }



}

class ShoppingCart {
    private String cartId;
    private String customerName;
    private Product[] products;
    private int[] quantities;
    private double cartTotal;
    private int itemCount;

    public ShoppingCart(String cartId, String customerName, int maxItems) {
        this.cartId = cartId;
        this.customerName = customerName;
        this.products = new Product[maxItems];
        this.quantities = new int[maxItems];
        this.cartTotal = 0.0;
        this.itemCount = 0;
    }

        public ShoppingCart(String customerName, int maxItems) {
            this.customerName = customerName;
            this.products = new Product[maxItems];
            this.quantities = new int[maxItems];
            this.cartTotal = 0.0;
            this.itemCount = 0;
        }
    public void addProduct(Product product, int quantity) {
        if (product != null && quantity > 0 && product.getStockQuantity() >= quantity) {
            products[itemCount] = product;
            quantities[itemCount] = quantity;
            product.reduceStock(quantity);
            itemCount++;
            calculateTotal();
            System.out.println("Added: " + product.getProductName() + " x" + quantity);
        } else {
            System.out.println("Cannot add product: Invalid quantity or out of stock.");
        }
    }

    public void removeProduct(String productId) {
        for (int i = 0; i < itemCount; i++) {
            if (products[i].getProductId().equals(productId)) {
                products[i].increaseStock(quantities[i]);
                System.out.println("Removed: " + products[i].getProductName());
                // Shift items left
                for (int j = i; j < itemCount - 1; j++) {
                    products[j] = products[j+1];
                    quantities[j] = quantities[j+1];
                }
                products[itemCount-1] = null;
                quantities[itemCount-1] = 0;
                itemCount--;
                calculateTotal();
                return;
            }
        }
        System.out.println("Product not found in cart.");
    }

    public void calculateTotal() {
        cartTotal = 0.0;
        for (int i = 0; i < itemCount; i++) {
            cartTotal += products[i].getPrice() * quantities[i];
        }
    }

    public void displayCart() {
        System.out.println("--- Cart Summary for " + customerName + " ---");
        for (int i = 0; i < itemCount; i++) {
            System.out.println(products[i].getProductName() + " x" + quantities[i] + " @ " + products[i].getPrice());
        }
        System.out.println("Total: " + cartTotal);
        System.out.println();
    }

    public void checkout() {
        System.out.println("Checking out. Total amount: " + cartTotal);
        products = new Product[products.length];
        quantities = new int[quantities.length];
        itemCount = 0;
        cartTotal = 0.0;
    }
}

public class Assignment2_YourName {
    public static void main(String[] args) {
        // Create 10 products
        Product[] products = new Product[] {
            new Product("P1", "Laptop", 50000, "Electronics", 5),
            new Product("P2", "Book", 500, "Books", 10),
            new Product("P3", "T-Shirt", 300, "Clothing", 20),
            new Product("P4", "Rice", 60, "Groceries", 50),
            new Product("P5", "Phone", 20000, "Electronics", 8),
            new Product("P6", "Notebook", 50, "Books", 30),
            new Product("P7", "Jeans", 800, "Clothing", 15),
            new Product("P8", "Oil", 120, "Groceries", 25),
            new Product("P9", "Headphones", 1500, "Electronics", 12),
            new Product("P10", "Pen", 20, "Books", 100)
        };

        ShoppingCart cart = new ShoppingCart("Alice", 10);
        cart.addProduct(products[0], 1); // Laptop
        cart.addProduct(products[1], 2); // Book
        cart.addProduct(products[2], 3); // T-Shirt
        cart.displayCart();

        cart.removeProduct("P2"); // Remove Book
        cart.displayCart();

        cart.checkout();
        cart.displayCart();

        // Show products by category
    }
}
