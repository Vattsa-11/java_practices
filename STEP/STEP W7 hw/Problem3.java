// PROBLEM 3: Transportation Fleet Management - Dynamic Method Dispatch

class Vehicle {
    protected String vehicleId;

    public Vehicle(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public void dispatch() {
        System.out.println("Dispatching vehicle: " + vehicleId);
    }
}

class Bus extends Vehicle {
    private String route;
    private int passengerCapacity;
    private int currentPassengers;

    public Bus(String vehicleId, String route, int passengerCapacity) {
        super(vehicleId);
        this.route = route;
        this.passengerCapacity = passengerCapacity;
        this.currentPassengers = 0;
    }

    @Override
    public void dispatch() {
        System.out.println("\n=== BUS DISPATCH ===");
        System.out.println("Bus ID: " + vehicleId);
        System.out.println("Route: " + route);
        System.out.println("Capacity: " + passengerCapacity + " passengers");
        System.out.println("Current passengers: " + currentPassengers);
        System.out.println("Following fixed route schedule");
        System.out.println("Status: Dispatched on route " + route);
    }
}

class Taxi extends Vehicle {
    private String pickupLocation;
    private String dropLocation;
    private double distance;

    public Taxi(String vehicleId, String pickupLocation, String dropLocation, double distance) {
        super(vehicleId);
        this.pickupLocation = pickupLocation;
        this.dropLocation = dropLocation;
        this.distance = distance;
    }

    @Override
    public void dispatch() {
        double fare = distance * 2.5 + 5.0; // Base fare + per km
        System.out.println("\n=== TAXI DISPATCH ===");
        System.out.println("Taxi ID: " + vehicleId);
        System.out.println("Pickup: " + pickupLocation);
        System.out.println("Drop-off: " + dropLocation);
        System.out.println("Distance: " + distance + " km");
        System.out.println("Calculated Fare: $" + fare);
        System.out.println("Status: Door-to-door service en route");
    }
}

class Train extends Vehicle {
    private String schedule;
    private int numberOfCars;
    private int carCapacity;

    public Train(String vehicleId, String schedule, int numberOfCars, int carCapacity) {
        super(vehicleId);
        this.schedule = schedule;
        this.numberOfCars = numberOfCars;
        this.carCapacity = carCapacity;
    }

    @Override
    public void dispatch() {
        int totalCapacity = numberOfCars * carCapacity;
        System.out.println("\n=== TRAIN DISPATCH ===");
        System.out.println("Train ID: " + vehicleId);
        System.out.println("Schedule: " + schedule);
        System.out.println("Number of cars: " + numberOfCars);
        System.out.println("Total capacity: " + totalCapacity + " passengers");
        System.out.println("Status: Departing on schedule");
    }
}

class Bike extends Vehicle {
    private String stationLocation;
    private boolean isEcoFriendly;

    public Bike(String vehicleId, String stationLocation) {
        super(vehicleId);
        this.stationLocation = stationLocation;
        this.isEcoFriendly = true;
    }

    @Override
    public void dispatch() {
        System.out.println("\n=== BIKE DISPATCH ===");
        System.out.println("Bike ID: " + vehicleId);
        System.out.println("Station: " + stationLocation);
        System.out.println("Eco-friendly: " + isEcoFriendly);
        System.out.println("Best for short distances");
        System.out.println("Status: Available for pickup");
    }
}

public class Problem3 {
    public static void main(String[] args) {
        // Dynamic Method Dispatch - same reference type, different behaviors
        Vehicle[] fleet = new Vehicle[4];
        
        fleet[0] = new Bus("BUS-101", "Downtown Express", 50);
        fleet[1] = new Taxi("TAXI-205", "Airport", "City Center", 15.5);
        fleet[2] = new Train("TRAIN-302", "8:00 AM - 6:00 PM", 8, 100);
        fleet[3] = new Bike("BIKE-450", "Central Park Station");
        
        System.out.println("===== UNIFIED DISPATCH SYSTEM =====");
        
        // Same method call, different behaviors at runtime
        for (Vehicle vehicle : fleet) {
            vehicle.dispatch();
        }
    }
}
