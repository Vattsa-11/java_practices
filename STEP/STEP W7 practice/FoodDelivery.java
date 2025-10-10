// Practice Problem 3: Food Delivery App - Dynamic Method Dispatch
// File: FoodDelivery.java

class Restaurant {
    protected String name;
    
    public Restaurant(String name) {
        this.name = name;
    }
    
    // Generic food preparation method
    public void prepareFood() {
        System.out.println(name + " is preparing generic food");
    }
    
    // Generic time estimation method
    public void estimateTime() {
        System.out.println("Estimated time: 30 minutes");
    }
}

class PizzaPlace extends Restaurant {
    public PizzaPlace(String name) {
        super(name);
    }
    
    // Override prepareFood for pizza
    @Override
    public void prepareFood() {
        System.out.println("🍕 " + name + " is making delicious pizza with fresh toppings!");
    }
    
    // Override estimateTime for pizza
    @Override
    public void estimateTime() {
        System.out.println("🍕 Pizza ready in 20 minutes!");
    }
}

class SushiBar extends Restaurant {
    public SushiBar(String name) {
        super(name);
    }
    
    // Override prepareFood for sushi
    @Override
    public void prepareFood() {
        System.out.println("🍣 " + name + " is crafting fresh sushi with precision!");
    }
    
    // Override estimateTime for sushi
    @Override
    public void estimateTime() {
        System.out.println("🍣 Sushi will be ready in 25 minutes!");
    }
}

public class FoodDelivery {
    public static void main(String[] args) {
        System.out.println("=== Dynamic Food Ordering System ===");
        
        // Create a Restaurant reference variable
        Restaurant restaurant;
        
        System.out.println("\n🍕 Ordering from Pizza Place:");
        // Assign new PizzaPlace to it
        restaurant = new PizzaPlace("Mario's Pizza");
        restaurant.prepareFood(); // Calls PizzaPlace method
        restaurant.estimateTime(); // Calls PizzaPlace method
        
        System.out.println("\n🍣 Changing order to Sushi Bar:");
        // Reassign to new SushiBar
        restaurant = new SushiBar("Tokyo Sushi");
        restaurant.prepareFood(); // Calls SushiBar method
        restaurant.estimateTime(); // Calls SushiBar method
        
        System.out.println("\n🏪 Trying generic restaurant:");
        restaurant = new Restaurant("Generic Eatery");
        restaurant.prepareFood(); // Calls Restaurant method
        restaurant.estimateTime(); // Calls Restaurant method
        
        System.out.println("\n=== How JVM knows which method to call at runtime: ===");
        System.out.println("🧠 The JVM looks at the ACTUAL OBJECT TYPE (not reference type)");
        System.out.println("🧠 This is called DYNAMIC METHOD DISPATCH");
        System.out.println("🧠 Method resolution happens at RUNTIME, not compile time");
    }
}