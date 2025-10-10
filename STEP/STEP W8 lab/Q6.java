// LAB PROBLEM 6: Abstract Device and Connectable Interface

// Interface Connectable
interface Connectable {
    void connect();
}

// Abstract class Device
abstract class Device {
    protected String brand;
    protected String model;
    
    abstract void powerOn();
}

// Smartphone class extending Device and implementing Connectable
class Smartphone extends Device implements Connectable {
    
    public Smartphone(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }
    
    @Override
    void powerOn() {
        System.out.println(brand + " " + model + " is powering on...");
        System.out.println("Device is ready to use!");
    }
    
    @Override
    public void connect() {
        System.out.println("Connecting to WiFi and Bluetooth...");
        System.out.println("Connection established!");
    }
    
    public void displayInfo() {
        System.out.println("Smartphone Details:");
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
    }
}

// Main class
public class Q6 {
    public static void main(String[] args) {
        Smartphone phone = new Smartphone("Samsung", "Galaxy S21");
        phone.displayInfo();
        phone.powerOn();
        phone.connect();
    }
}
