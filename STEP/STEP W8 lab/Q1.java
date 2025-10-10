// LAB PROBLEM 1: Abstract Fruit and Edible Interface

// Interface Edible
interface Edible {
    void nutrientsInfo();
}

// Abstract class Fruit
abstract class Fruit {
    protected String color;
    protected String taste;
    
    abstract void showDetails();
}

// Apple class extending Fruit and implementing Edible
class Apple extends Fruit implements Edible {
    private String variety;
    
    public Apple(String color, String taste, String variety) {
        this.color = color;
        this.taste = taste;
        this.variety = variety;
    }
    
    @Override
    void showDetails() {
        System.out.println("Apple Details:");
        System.out.println("Color: " + color);
        System.out.println("Taste: " + taste);
        System.out.println("Variety: " + variety);
    }
    
    @Override
    public void nutrientsInfo() {
        System.out.println("Nutrients: Rich in Vitamin C, Fiber, and Antioxidants");
    }
}

// Main class
public class Q1 {
    public static void main(String[] args) {
        Apple apple = new Apple("Red", "Sweet", "Fuji");
        apple.showDetails();
        apple.nutrientsInfo();
    }
}
