class Fruit {
    protected String color;
    protected String taste;
    
    public Fruit(String color, String taste) {
        this.color = color;
        this.taste = taste;
    }
    
    public void displayInfo() {
        System.out.println("Fruit - Color: " + color + ", Taste: " + taste);
    }
}

class Apple extends Fruit {
    private String variety;
    
    public Apple(String color, String taste, String variety) {
        super(color, taste);
        this.variety = variety;
    }
    
    public void displayAppleInfo() {
        displayInfo();
        System.out.println("Apple Variety: " + variety);
    }
}

public class Q1 {
    public static void main(String[] args) {
        Apple apple = new Apple("Red", "Sweet", "Honeycrisp");
        apple.displayAppleInfo();
        
        // Accessing inherited fields directly
        System.out.println("\nAccessing inherited fields:");
        System.out.println("Color: " + apple.color);
        System.out.println("Taste: " + apple.taste);
    }
}