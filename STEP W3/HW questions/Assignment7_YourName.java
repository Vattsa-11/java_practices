/**
 * Assignment 7: Vehicle Fleet Management System
 * Author: YourName
 * Date: 2025-09-01
 *
 * Simple vehicle fleet management system demonstrating inheritance and resource management.
 */
class Vehicle {
    protected String vehicleId;
    protected String brand;
    protected String model;
    protected int year;
    protected double mileage;
    protected String fuelType;
    protected String currentStatus;

    protected static int totalVehicles = 0;
    protected static double fleetValue = 0.0;
    protected static String companyName = "Default Transport";
    protected static double totalFuelConsumption = 0.0;

    public Vehicle(String id, String brand, String model, int year, double mileage, String fuel, String status) {
        this.vehicleId = id;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.mileage = mileage;
        this.fuelType = fuel;
        this.currentStatus = status;
        totalVehicles++;
    }

    public void updateMileage(double miles) {
        mileage += miles;
        totalFuelConsumption += miles * 0.1; // Simple consumption
    }
}

class Car extends Vehicle {
    public Car(String id, String brand, String model, int year, double mileage, String fuel, String status) {
        super(id, brand, model, year, mileage, fuel, status);
    }
}

class Bus extends Vehicle {
    public Bus(String id, String brand, String model, int year, double mileage, String fuel, String status, int seats) {
        super(id, brand, model, year, mileage, fuel, status);
    }
}

class Truck extends Vehicle {
    public Truck(String id, String brand, String model, int year, double mileage, String fuel, String status, double load) {
        super(id, brand, model, year, mileage, fuel, status);
    }
}

class Driver {
    private String driverName;
    public Driver(String name) {
        this.driverName = name;
    }
    public void assignVehicle(Vehicle v) {
        System.out.println(driverName + " assigned to vehicle " + v.vehicleId);
    }
}

public class Assignment7_YourName {
    public static void main(String[] args) {
        Vehicle.companyName = "FleetX";
        Car car1 = new Car("V1", "Toyota", "Corolla", 2020, 20000, "Petrol", "Available");
        Bus bus1 = new Bus("V2", "Volvo", "9400", 2018, 50000, "Diesel", "Available", 50);
        Truck truck1 = new Truck("V3", "Tata", "Ultra", 2019, 40000, "Diesel", "Available", 10.5);

    Driver d1 = new Driver("Alice");
    Driver d2 = new Driver("Bob");
    Driver d3 = new Driver("Charlie");

        d1.assignVehicle(car1);
        d2.assignVehicle(bus1);
        d3.assignVehicle(truck1);

        car1.updateMileage(500);
        bus1.updateMileage(1000);
        truck1.updateMileage(800);

        System.out.println("Total Vehicles: " + Vehicle.totalVehicles);
        System.out.println("Company Name: " + Vehicle.companyName);
        System.out.println("Total Fuel Consumption: " + Vehicle.totalFuelConsumption);
    }
}
