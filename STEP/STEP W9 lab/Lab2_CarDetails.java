class Car {
    private String brand;
    private String model;
    private double price;
    
    public Car(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }
    
    // Override toString() method to display object details
    @Override
    public String toString() {
        return "Car{brand='" + brand + "', model='" + model + "', price=$" + price + "}";
    }
}

public class Lab2_CarDetails {
    public static void main(String[] args) {
        // Create Car objects
        Car car1 = new Car("Toyota", "Camry", 25000.00);
        Car car2 = new Car("Honda", "Accord", 28000.00);
        Car car3 = new Car("Tesla", "Model 3", 45000.00);
        
        System.out.println("--- Displaying Car Objects (using toString()) ---");
        System.out.println(car1);
        System.out.println(car2);
        System.out.println(car3);
        
        System.out.println("\n--- Getting Class Information (using getClass()) ---");
        System.out.println("car1 class name: " + car1.getClass().getName());
        System.out.println("car2 class name: " + car2.getClass().getName());
        System.out.println("car3 class name: " + car3.getClass().getName());
        
        System.out.println("\n--- Additional Class Information ---");
        System.out.println("Simple class name: " + car1.getClass().getSimpleName());
        System.out.println("Package name: " + (car1.getClass().getPackage() != null ? 
                                                car1.getClass().getPackage().getName() : "default package"));
    }
}
