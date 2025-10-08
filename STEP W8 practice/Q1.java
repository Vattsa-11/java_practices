// Problem 1: Vehicle with Abstract Class

abstract class Vehicle {
    // Abstract method start()
    public abstract void start();
    
    // Non-abstract method fuelType() -> print "Uses fuel"
    public void fuelType() {
        System.out.println("Uses fuel");
    }
}

class Car extends Vehicle {
    // Implement start() -> "Car starts with key"
    @Override
    public void start() {
        System.out.println("Car starts with key");
    }
}

class Bike extends Vehicle {
    // Implement start() -> "Bike starts with kick"
    @Override
    public void start() {
        System.out.println("Bike starts with kick");
    }
}

public class Q1 {
    public static void main(String[] args) {
        // Create Vehicle reference pointing to Car
        Vehicle car = new Car();
        car.start();
        car.fuelType();
        
        System.out.println();
        
        // Create Vehicle reference pointing to Bike
        Vehicle bike = new Bike();
        bike.start();
        bike.fuelType();
    }
}