// Problem 4: Food Preparation Template

abstract class Food {
    protected String name;
    
    public Food(String name) {
        this.name = name;
    }
    
    // Template method - defines the algorithm
    public final void prepare() {
        System.out.println("\n=== Preparing " + name + " ===");
        wash();
        cook();
        serve();
        System.out.println("=== " + name + " is ready! ===");
    }
    
    // Abstract methods to be implemented by subclasses
    protected abstract void wash();
    protected abstract void cook();
    protected abstract void serve();
}

class Pizza extends Food {
    public Pizza() {
        super("Pizza");
    }
    
    @Override
    protected void wash() {
        System.out.println("Washing vegetables and cleaning workspace");
    }
    
    @Override
    protected void cook() {
        System.out.println("Rolling dough, adding toppings, baking in oven at 450°F for 15 minutes");
    }
    
    @Override
    protected void serve() {
        System.out.println("Cutting into slices and serving hot on plates");
    }
}

class Soup extends Food {
    public Soup() {
        super("Soup");
    }
    
    @Override
    protected void wash() {
        System.out.println("Washing vegetables and cleaning pot");
    }
    
    @Override
    protected void cook() {
        System.out.println("Chopping vegetables, boiling in water, simmering for 30 minutes");
    }
    
    @Override
    protected void serve() {
        System.out.println("Ladling into bowls and garnishing with herbs");
    }
}

public class Problem4 {
    public static void main(String[] args) {
        Food pizza = new Pizza();
        Food soup = new Soup();
        
        // Template method in action
        pizza.prepare();
        soup.prepare();
    }
}