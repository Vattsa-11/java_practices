// Problem 4: Food Delivery Order
public class FoodOrder {
    String customerName;
    String foodItem;
    int quantity;
    double price;
    static final double FIXED_RATE = 150.0;

    // Default constructor
    public FoodOrder() {
        this("Unknown", "Unknown", 0, 0.0);
    }
    // Constructor with food item
    public FoodOrder(String foodItem) {
        this("Unknown", foodItem, 1, FIXED_RATE);
    }
    // Constructor with food item and quantity
    public FoodOrder(String foodItem, int quantity) {
        this("Unknown", foodItem, quantity, quantity * FIXED_RATE);
    }
    // Full constructor
    public FoodOrder(String customerName, String foodItem, int quantity, double price) {
        this.customerName = customerName;
        this.foodItem = foodItem;
        this.quantity = quantity;
        this.price = price;
    }
    public void printBill() {
        System.out.printf("Customer: %s | Food: %s | Qty: %d | Total: %.2f\n", customerName, foodItem, quantity, price);
    }
    public static void main(String[] args) {
        FoodOrder o1 = new FoodOrder();
        FoodOrder o2 = new FoodOrder("Burger");
        FoodOrder o3 = new FoodOrder("Pizza", 3);
        FoodOrder o4 = new FoodOrder("Alice", "Sandwich", 2, 300.0);
        o1.printBill();
        o2.printBill();
        o3.printBill();
        o4.printBill();
    }
}
