// Problem 2: Tool Access Levels

class Tool {
    private String model;           // Private - not accessible from child
    protected String brand;         // Protected - accessible from child
    public String type;            // Public - accessible from child
    String material;               // Default - accessible from same package
    
    public Tool(String model, String brand, String type, String material) {
        this.model = model;
        this.brand = brand;
        this.type = type;
        this.material = material;
    }
    
    // Getter for private field
    public String getModel() {
        return model;
    }
    
    public void displayTool() {
        System.out.println("Tool - Model: " + model + ", Brand: " + brand + 
                          ", Type: " + type + ", Material: " + material);
    }
}

class Hammer extends Tool {
    private double weight;
    
    public Hammer(String model, String brand, String material, double weight) {
        super(model, brand, "Hammer", material);
        this.weight = weight;
    }
    
    public void testAccess() {
        System.out.println("Testing field access from Hammer class:");
        
        // Private field - NOT accessible directly
        // System.out.println("Model: " + model);  // This would cause error
        System.out.println("Model (via getter): " + getModel());  // Accessible via getter
        
        // Protected field - accessible
        System.out.println("Brand (protected): " + brand);
        
        // Public field - accessible
        System.out.println("Type (public): " + type);
        
        // Default field - accessible (same package)
        System.out.println("Material (default): " + material);
        
        System.out.println("Weight: " + weight);
    }
    
    public void displayHammer() {
        displayTool();
        System.out.println("Weight: " + weight + " lbs");
    }
}

public class Problem2 {
    public static void main(String[] args) {
        Hammer hammer = new Hammer("H-123", "Stanley", "Steel", 2.5);
        
        System.out.println("Direct field access from main:");
        // hammer.model;     // Error - private
        System.out.println("Brand: " + hammer.brand);      // OK - protected
        System.out.println("Type: " + hammer.type);        // OK - public
        System.out.println("Material: " + hammer.material); // OK - default (same package)
        
        System.out.println("\nAccess test from child class:");
        hammer.testAccess();
        
        System.out.println("\nComplete hammer display:");
        hammer.displayHammer();
    }
}