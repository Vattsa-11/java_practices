import java.util.Scanner;

public class BMI {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Number of Persons: ");
        int persons = input.nextInt();
        double[] weight = new double[persons];
        double[] height = new double[persons];
        double[] bmi = new double[persons];
        String[] weight_status = new String[persons];

        for (int i = 0; i < persons; i++) {
            System.out.print("Enter Weight of Person "+(i+1)+" (in kg): ");
            weight[i] = input.nextInt();
            System.out.print("Enter height of Person "+(i+1)+" (in cm): ");
            height[i] = input.nextInt()/100.0;
            bmi[i] = weight[i]/(height[i]*height[i]);
            if (bmi[i] <= 18.4) weight_status[i] = "Underweight";
            else if (bmi[i] > 18.4 && bmi[i] <= 24.9) weight_status[i] = "Normal";
            else if (bmi[i] > 24.9 && bmi[i] <= 39.9) weight_status[i] = "Overweight";
            else weight_status[i] = "Obese";
        }

        for (int j = 0; j < persons; j++) {
            System.out.printf("\nPerson %d: \nWeight: %.2f\nHeight: %.2f\nBMI: %.2f\nWeight Status: %s", (j+1), weight[j], height[j], bmi[j], weight_status[j]);
        }
        input.close();
    }
}
