import java.util.Scanner;

public class UnitConverter3 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter temperature in Fahrenheit: ");
        double fr = input.nextDouble();
        System.out.printf("Fahrenheit to Celsius: %.2f\n", fahrenheit2celsius(fr));
        System.out.print("Enter temperature in Celsius: ");
        double cl = input.nextDouble();
        System.out.printf("Celsius to Fahrenheit : %.2f\n", celsius2fahrenheit(cl));
        System.out.print("Enter weight in Pounds: ");
        double pnd = input.nextDouble();
        System.out.printf("Pounds to Kilogram: %.2f\n", pounds2kilograms(pnd));
        System.out.print("Enter weight in Kilogram: ");
        double kg = input.nextDouble();
        System.out.printf("Kilogram to Pounds: %.2f\n", kilograms2pounds(kg));
        System.out.print("Enter volume in Gallons: ");
        double gal = input.nextDouble();
        System.out.printf("Gallons to Liter: %.2f\n", gallons2liter(gal));
        System.out.print("Enter volume in Liters: ");
        double lit = input.nextDouble();
        System.out.printf("Liter to Gallons: %.2f\n", liters2gallon(lit));


    }
    public static double fahrenheit2celsius(double fahr){
        double fahrenheit2celsius = (fahr - 32) * 5 / 9;
        return fahrenheit2celsius;
    }
    public static double celsius2fahrenheit(double cel){
        double celsius2fahrenheit = (cel * 9 / 5) + 32;
        return celsius2fahrenheit;
    }
    public static double pounds2kilograms(double pounds){
        double pounds2kilograms = 0.453592;
        return pounds * pounds2kilograms;
    }
    public static double kilograms2pounds(double kg){
        double kilograms2pounds = 2.20462;
        return kg * kilograms2pounds;
    }
    public static double gallons2liter(double gallons){
        double gallons2liter = 3.78541;
        return gallons * gallons2liter;
    }
    public static double liters2gallon(double liter){
        double liters2gallon = 0.264172;
        return liter * liters2gallon;
    }
}
