import java.util.Scanner;

public class UnitConverter2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter distance in Yards: ");
        double yard = input.nextDouble();
        System.out.printf("Yards to Feet: %.2f\n", yards2feet(yard));
        System.out.print("Enter distance in Feet: ");
        double feet = input.nextDouble();
        System.out.printf("Feet to Yards: %.2f\n", feet2yards(feet));
        System.out.print("Enter distance in Meter: ");
        double meter = input.nextDouble();
        System.out.printf("Meter to Inches: %.2f\n", meters2inches(meter));
        System.out.print("Enter distance in Inches: ");
        double inches = input.nextDouble();
        System.out.printf("Inches to Meter: %.2f\n", inches2meter(inches));
        System.out.print("Enter distance in Inches: ");
        double inches2 = input.nextDouble();
        System.out.printf("Inches to Cm: %.2f\n", inches2cm(inches2));
    }
    public static double yards2feet(double yard){
        double yards2feet = 3;
        return yard * yards2feet;
    }
    public static double feet2yards(double feet){
        double feet2yards = 0.333333;
        return  feet * feet2yards;
    }
    public static double meters2inches(double meter){
        double meters2inches = 39.3701;
        return meter * meters2inches;
    }
    public static double inches2meter(double inches){
        double inches2meter = 0.0254;
        return inches * inches2meter;
    }
    public static double inches2cm(double inches){
        double inches2cm = 2.54;
        return inches * inches2cm;
    }
}