class Phone {
    protected String brand;
    protected String model;
    
    public Phone() {
        System.out.println("Phone default constructor called");
        this.brand = "Unknown";
        this.model = "Basic";
    }
    
    public Phone(String brand, String model) {
        System.out.println("Phone parameterized constructor called");
        this.brand = brand;
        this.model = model;
    }
}

class SmartPhone extends Phone {
    private String operatingSystem;
    
    public SmartPhone() {
        super();
        System.out.println("SmartPhone default constructor called");
        this.operatingSystem = "Android";
    }
    
    public SmartPhone(String brand, String model, String os) {
        super(brand, model);
        System.out.println("SmartPhone parameterized constructor called");
        this.operatingSystem = os;
    }
    
    public void displayInfo() {
        System.out.println("Brand: " + brand + ", Model: " + model + 
                         ", OS: " + operatingSystem);
    }
}

public class Q2 {
    public static void main(String[] args) {
        System.out.println("Creating default smartphone:");
        SmartPhone phone1 = new SmartPhone();
        phone1.displayInfo();
        
        System.out.println("\nCreating custom smartphone:");
        SmartPhone phone2 = new SmartPhone("Apple", "iPhone 14", "iOS");
        phone2.displayInfo();
    }
}