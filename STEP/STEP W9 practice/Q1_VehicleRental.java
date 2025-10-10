class Vehicle {
    private String registrationNo;
    private String type;
    private double ratePerDay;
    
    // Constructor initializing all fields
    public Vehicle(String registrationNo, String type, double ratePerDay) {
        this.registrationNo = registrationNo;
        this.type = type;
        this.ratePerDay = ratePerDay;
    }
    
    // Override toString()
    @Override
    public String toString() {
        return "Vehicle: [" + registrationNo + "], Type: [" + type + "], Rate: $" + ratePerDay + "/day";
    }
    
    // Getters for all fields
    public String getRegistrationNo() {
        return registrationNo;
    }
    
    public String getType() {
        return type;
    }
    
    public double getRatePerDay() {
        return ratePerDay;
    }
}

public class Q1_VehicleRental {
    public static void main(String[] args) {
        // 1. Create Vehicle
        Vehicle v1 = new Vehicle("MH12AB1234", "Sedan", 1500);
        
        // 2. Print the Vehicle object and observe output
        System.out.println(v1);
        
        // 3. Create another vehicle and compare
        Vehicle v2 = new Vehicle("DL01CD5678", "SUV", 2500);
        System.out.println(v2);
        
        System.out.println("\nComparison:");
        System.out.println("v1 == v2: " + (v1 == v2));
        System.out.println("v1.equals(v2): " + v1.equals(v2));
    }
}
