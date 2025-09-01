/**
 * Assignment 3: Hotel Reservation System
 * Author: Srivattsa
 * Date: 2025-09-01
 *
 * Simple hotel reservation system demonstrating OOP concepts and class interactions.
 */
class Room {
    private String roomNumber;
    private String roomType;
    private double pricePerNight;
    private boolean isAvailable;

    public Room(String number, String type, double price) {
        this.roomNumber = number;
        this.roomType = type;
        this.pricePerNight = price;
        this.isAvailable = true;
    }

    public String getRoomNumber() { return roomNumber; }
    public String getRoomType() { return roomType; }
    public double getPricePerNight() { return pricePerNight; }
    public boolean isAvailable() { return isAvailable; }
    public void setAvailable(boolean available) { this.isAvailable = available; }
}

class Guest {
    public Guest() {}
}

class Booking {
    private String bookingId;
    private double totalAmount;

    private static int totalBookings = 0;
    private static double hotelRevenue = 0.0;
    private static String hotelName = "Default Hotel";

    private Room room;

    public Booking(Room room) {
        this.bookingId = "BKG" + (1000 + totalBookings);
        this.room = room;
        this.totalAmount = room.getPricePerNight();
        totalBookings++;
        hotelRevenue += totalAmount;
        room.setAvailable(false);
    }

    public void cancelReservation() {
        room.setAvailable(true);
        hotelRevenue -= totalAmount;
        System.out.println("Booking cancelled: " + bookingId);
    }

    public static double getTotalRevenue() { return hotelRevenue; }
    public static int getTotalBookings() { return totalBookings; }
    public static String getHotelName() { return hotelName; }
    public static void setHotelName(String name) { hotelName = name; }
}

public class Assignment3_Srivattsa {
    public static void main(String[] args) {
        Booking.setHotelName("Sunrise Hotel");
        Room[] rooms = {
            new Room("101", "Single", 1000),
            new Room("102", "Double", 1500),
            new Room("201", "Suite", 3000)
        };

        // Make reservations
        Booking booking1 = new Booking(rooms[0]);
        Booking booking2 = new Booking(rooms[1]);

        System.out.println("Total Bookings: " + Booking.getTotalBookings());
        System.out.println("Hotel Revenue: " + Booking.getTotalRevenue());
        System.out.println("Hotel Name: " + Booking.getHotelName());

        // Cancel a booking
        booking1.cancelReservation();
        System.out.println("Hotel Revenue after cancellation: " + Booking.getTotalRevenue());
    }
}
