public class Vehicle {
    protected String make;
    protected String model;
    protected int year;
    protected double fuelLevel;
    
    public Vehicle(String make, String model, int year, double fuelLevel) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.fuelLevel = fuelLevel;
    }
    
    public void startVehicle() {
        System.out.println(make + " " + model + " is starting...");
    }
    
    public void stopVehicle() {
        System.out.println(make + " " + model + " is stopping...");
    }
    
    public void refuel(double amount) {
        fuelLevel += amount;
        System.out.println("Refueled. New fuel level: " + fuelLevel);
    }
    
    public void displayVehicleInfo() {
        System.out.println("Vehicle: " + year + " " + make + " " + model);
        System.out.println("Fuel level: " + fuelLevel);
    }
    
    public static void main(String[] args) {
        Vehicle car = new Vehicle("Toyota", "Camry", 2021, 50.0);
        Vehicle truck = new Vehicle("Ford", "F-150", 2020, 75.0);
        Vehicle motorcycle = new Vehicle("Honda", "CBR", 2022, 20.0);
        
        Vehicle[] vehicles = {car, truck, motorcycle};
        
        for (Vehicle v : vehicles) {
            v.displayVehicleInfo();
            v.startVehicle();
            v.refuel(10.0);
            v.stopVehicle();
            System.out.println();
        }
    }
}