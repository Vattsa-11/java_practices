// PROBLEM 1: Hotel Booking System - Method Overloading

class HotelBooking {
    private static final double STANDARD_ROOM = 100.0;
    private static final double DELUXE_ROOM = 200.0;
    private static final double SUITE = 300.0;

    // Standard booking - just room type and nights
    public void bookRoom(String roomType, int nights) {
        double price = getRoomPrice(roomType);
        double total = price * nights;
        
        System.out.println("\n=== STANDARD BOOKING ===");
        System.out.println("Room Type: " + roomType);
        System.out.println("Nights: " + nights);
        System.out.println("Price per night: $" + price);
        System.out.println("Total Cost: $" + total);
    }

    // Seasonal booking - with seasonal multiplier
    public void bookRoom(String roomType, int nights, double seasonalMultiplier) {
        double price = getRoomPrice(roomType);
        double baseTotal = price * nights;
        double total = baseTotal * seasonalMultiplier;
        
        System.out.println("\n=== SEASONAL BOOKING ===");
        System.out.println("Room Type: " + roomType);
        System.out.println("Nights: " + nights);
        System.out.println("Base price per night: $" + price);
        System.out.println("Seasonal multiplier: " + seasonalMultiplier + "x");
        System.out.println("Base total: $" + baseTotal);
        System.out.println("Total Cost: $" + total);
    }

    // Corporate booking - with discount and meal package
    public void bookRoom(String roomType, int nights, int discountPercent, double mealPackage) {
        double price = getRoomPrice(roomType);
        double baseTotal = price * nights;
        double discount = baseTotal * discountPercent / 100;
        double afterDiscount = baseTotal - discount;
        double total = afterDiscount + mealPackage;
        
        System.out.println("\n=== CORPORATE BOOKING ===");
        System.out.println("Room Type: " + roomType);
        System.out.println("Nights: " + nights);
        System.out.println("Base total: $" + baseTotal);
        System.out.println("Corporate discount (" + discountPercent + "%): -$" + discount);
        System.out.println("After discount: $" + afterDiscount);
        System.out.println("Meal package: +$" + mealPackage);
        System.out.println("Total Cost: $" + total);
        System.out.println("Total Savings: $" + discount);
    }

    // Wedding package - with guest count, decoration, and catering
    public void bookRoom(String roomType, int nights, int guestCount, double decorationFee, String cateringOption) {
        double price = getRoomPrice(roomType);
        double roomTotal = price * nights;
        double cateringCost = getCateringCost(cateringOption, guestCount);
        double total = roomTotal + decorationFee + cateringCost;
        
        System.out.println("\n=== WEDDING PACKAGE ===");
        System.out.println("Room Type: " + roomType);
        System.out.println("Nights: " + nights);
        System.out.println("Guest Count: " + guestCount);
        System.out.println("Room cost: $" + roomTotal);
        System.out.println("Decoration fee: $" + decorationFee);
        System.out.println("Catering (" + cateringOption + "): $" + cateringCost);
        System.out.println("Total Cost: $" + total);
    }

    private double getRoomPrice(String roomType) {
        switch(roomType.toLowerCase()) {
            case "standard": return STANDARD_ROOM;
            case "deluxe": return DELUXE_ROOM;
            case "suite": return SUITE;
            default: return STANDARD_ROOM;
        }
    }

    private double getCateringCost(String option, int guests) {
        double perPersonCost;
        switch(option.toLowerCase()) {
            case "basic": perPersonCost = 25.0; break;
            case "premium": perPersonCost = 50.0; break;
            case "luxury": perPersonCost = 100.0; break;
            default: perPersonCost = 25.0;
        }
        return perPersonCost * guests;
    }
}

public class Problem1 {
    public static void main(String[] args) {
        HotelBooking booking = new HotelBooking();
        
        // Standard booking
        booking.bookRoom("Deluxe", 3);
        
        // Seasonal booking
        booking.bookRoom("Suite", 5, 1.5);
        
        // Corporate booking
        booking.bookRoom("Deluxe", 7, 20, 150.0);
        
        // Wedding package
        booking.bookRoom("Suite", 2, 50, 500.0, "Premium");
    }
}
