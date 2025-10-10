import java.util.Scanner;

public class BMICalculator {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your Weight (in kg): ");
        double weight = input.nextDouble();
        System.out.print("Enter your Height (in cm): ");
        double height = (input.nextDouble())/100.0;
        double bmi = weight/(height*height);
        if (bmi <= 18.4) System.out.print("Underweight");
        else if (bmi > 18.4 && bmi <= 24.9) System.out.print("Normal");
        else if (bmi > 24.9 && bmi <= 39.9) System.out.print("Overweight");
        else System.out.print("Obese");
        input.close();
    }
}
