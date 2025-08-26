import java.util.Scanner;

public class UnitConvertor {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter distance in km: ");
        double km = input.nextDouble();
        System.out.printf("Km to Miles: %.2f\n", km2miles(km));
        System.out.print("Enter distance in miles: ");
        double miles = input.nextDouble();
        System.out.printf("Miles to Km: %.2f\n", miles2km(miles));
        System.out.print("Enter distance in meter: ");
        double meter = input.nextDouble();
        System.out.printf("Meter to Feet: %.2f\n", meters2feet(meter));
        System.out.print("Enter distance in feet: ");
        double feet = input.nextDouble();
        System.out.printf("Feet to Meter: %.2f\n", feet2meters(feet));
    }
    public static double km2miles(double km){
        double km2miles = 0.621371;
        return km * km2miles;
    }
    public static double miles2km(double miles){
        double miles2km = 1.60934;
        return miles * miles2km;
    }
    public static double meters2feet(double meter){
        double meters2feet = 3.28084;
        return meter * meters2feet;
    }
    public static double feet2meters(double feet){
        double feet2meters = 0.3048;
        return feet * feet2meters;
    }
}