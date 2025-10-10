// Topic 3: Abstract Class + Interface Together

// Interface Fuel
interface Fuel {
    void refuel();
}

// Abstract class Vehicle
abstract class Vehicle {
    abstract void start();
    
    // Concrete method
    void stop() {
        System.out.println("Vehicle stopped");
    }
}

// Car class extending Vehicle and implementing Fuel
class Car extends Vehicle implements Fuel {
    private String model;
    
    public Car(String model) {
        this.model = model;
    }
    
    @Override
    void start() {
        System.out.println(model + " car is starting...");
    }
    
    @Override
    public void refuel() {
        System.out.println(model + " car is refueling...");
    }
}

// Main class
public class Q3 {
    public static void main(String[] args) {
        Car car = new Car("Honda");
        car.start();
        car.refuel();
        car.stop();
    }
}
