// Problem 1: Food Delivery App - Method Overloading
public class Problem1 {
    private static final double BASE_RATE_PER_KM = 2.5;
    private static final double PRIORITY_FEE = 5.0;
    private static final double GROUP_DISCOUNT_PER_ORDER = 1.0;
    private static final double FREE_DELIVERY_THRESHOLD = 50.0;
    
    // Method Overloading - Same method name, different parameters
    
    // Basic delivery - just distance
    public double calculateDeliveryCharges(double distance) {
        double cost = distance * BASE_RATE_PER_KM;
        System.out.println("🚚 BASIC DELIVERY");
        System.out.println("Distance: " + distance + " km");
        System.out.println("Rate: $" + BASE_RATE_PER_KM + " per km");
        System.out.println("Total delivery cost: $" + cost);
        System.out.println("Standard delivery time: " + (distance * 10 + 30) + " minutes");
        return cost;
    }
    
    // Premium delivery - distance + priority fee
    public double calculateDeliveryCharges(double distance, boolean isPriority) {
        double cost = distance * BASE_RATE_PER_KM;
        if (isPriority) {
            cost += PRIORITY_FEE;
        }
        
        System.out.println("⚡ PREMIUM DELIVERY");
        System.out.println("Distance: " + distance + " km");
        System.out.println("Base cost: $" + (distance * BASE_RATE_PER_KM));
        if (isPriority) {
            System.out.println("Priority fee: $" + PRIORITY_FEE);
            System.out.println("Delivery time: " + (distance * 5 + 15) + " minutes (FAST!)");
        }
        System.out.println("Total delivery cost: $" + cost);
        return cost;
    }
    
    // Group delivery - distance + number of orders discount
    public double calculateDeliveryCharges(double distance, int numberOfOrders) {
        double baseCost = distance * BASE_RATE_PER_KM;
        double discount = (numberOfOrders - 1) * GROUP_DISCOUNT_PER_ORDER;
        double cost = Math.max(baseCost - discount, baseCost * 0.3); // Minimum 30% of base cost
        
        System.out.println("👥 GROUP DELIVERY");
        System.out.println("Distance: " + distance + " km");
        System.out.println("Number of orders: " + numberOfOrders);
        System.out.println("Base cost: $" + baseCost);
        System.out.println("Group discount: -$" + discount);
        System.out.println("Final cost: $" + cost);
        System.out.println("Savings per order: $" + ((baseCost - cost) / numberOfOrders));
        return cost;
    }
    
    // Festival special - distance + discount percentage + free delivery over certain amount
    public double calculateDeliveryCharges(double distance, double discountPercentage, double orderValue) {
        double baseCost = distance * BASE_RATE_PER_KM;
        double cost = baseCost;
        
        System.out.println("🎉 FESTIVAL SPECIAL DELIVERY");
        System.out.println("Distance: " + distance + " km");
        System.out.println("Order value: $" + orderValue);
        System.out.println("Base delivery cost: $" + baseCost);
        
        // Check for free delivery
        if (orderValue >= FREE_DELIVERY_THRESHOLD) {
            cost = 0;
            System.out.println("🎁 FREE DELIVERY! (Order above $" + FREE_DELIVERY_THRESHOLD + ")");
        } else {
            // Apply discount
            double discountAmount = baseCost * (discountPercentage / 100);
            cost = baseCost - discountAmount;
            System.out.println("Festival discount (" + discountPercentage + "%): -$" + discountAmount);
            System.out.println("You need $" + (FREE_DELIVERY_THRESHOLD - orderValue) + " more for FREE delivery!");
        }
        
        System.out.println("Final delivery cost: $" + cost);
        return cost;
    }
    
    // Bonus overloaded method - comprehensive delivery with all options
    public double calculateDeliveryCharges(double distance, boolean isPriority, int numberOfOrders, 
                                         double discountPercentage, double orderValue) {
        System.out.println("🌟 COMPREHENSIVE DELIVERY CALCULATION");
        System.out.println("Distance: " + distance + " km");
        System.out.println("Order value: $" + orderValue);
        System.out.println("Number of orders: " + numberOfOrders);
        
        double baseCost = distance * BASE_RATE_PER_KM;
        double cost = baseCost;
        
        // Apply priority fee
        if (isPriority) {
            cost += PRIORITY_FEE;
            System.out.println("Priority fee: +$" + PRIORITY_FEE);
        }
        
        // Apply group discount
        if (numberOfOrders > 1) {
            double groupDiscount = (numberOfOrders - 1) * GROUP_DISCOUNT_PER_ORDER;
            cost -= groupDiscount;
            System.out.println("Group discount: -$" + groupDiscount);
        }
        
        // Apply percentage discount
        if (discountPercentage > 0) {
            double percentDiscount = cost * (discountPercentage / 100);
            cost -= percentDiscount;
            System.out.println("Festival discount (" + discountPercentage + "%): -$" + percentDiscount);
        }
        
        // Check for free delivery
        if (orderValue >= FREE_DELIVERY_THRESHOLD) {
            cost = 0;
            System.out.println("🎁 FREE DELIVERY! (Order above $" + FREE_DELIVERY_THRESHOLD + ")");
        }
        
        // Ensure minimum cost
        cost = Math.max(cost, 0);
        System.out.println("Final delivery cost: $" + cost);
        
        return cost;
    }
    
    public static void main(String[] args) {
        System.out.println("=== Food Delivery App - Method Overloading Demo ===\n");
        
        Problem1 deliverySystem = new Problem1();
        
        System.out.println("1. Basic Delivery (5 km):");
        deliverySystem.calculateDeliveryCharges(5.0);
        System.out.println("\n" + "=".repeat(50) + "\n");
        
        System.out.println("2. Premium Delivery (5 km, priority):");
        deliverySystem.calculateDeliveryCharges(5.0, true);
        System.out.println("\n" + "=".repeat(50) + "\n");
        
        System.out.println("3. Group Delivery (5 km, 4 orders):");
        deliverySystem.calculateDeliveryCharges(5.0, 4);
        System.out.println("\n" + "=".repeat(50) + "\n");
        
        System.out.println("4. Festival Special (5 km, 20% discount, $30 order):");
        deliverySystem.calculateDeliveryCharges(5.0, 20.0, 30.0);
        System.out.println("\n" + "=".repeat(50) + "\n");
        
        System.out.println("5. Festival Special with Free Delivery (5 km, 15% discount, $60 order):");
        deliverySystem.calculateDeliveryCharges(5.0, 15.0, 60.0);
        System.out.println("\n" + "=".repeat(50) + "\n");
        
        System.out.println("6. Comprehensive Delivery (3 km, priority, 3 orders, 10% discount, $45 order):");
        deliverySystem.calculateDeliveryCharges(3.0, true, 3, 10.0, 45.0);
        System.out.println("\n" + "=".repeat(50) + "\n");
        
        System.out.println("🎯 Method Overloading Demo Complete!");
        System.out.println("Same method name 'calculateDeliveryCharges' with different parameters!");
        System.out.println("Java automatically selects the right method based on the arguments provided.");
    }
}