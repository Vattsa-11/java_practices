import java.util.Scanner;

public class BMI2d {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Number of Persons: ");
        int persons = input.nextInt();
        double[][] personData = new double[persons][3];
        String[] weight_status = new String[persons];

        for (int i = 0; i < persons; i++) {
            System.out.print("Enter Weight of Person "+(i+1)+" (in kg): ");
            personData[i][0] = input.nextInt();
            System.out.print("Enter height of Person "+(i+1)+" (in cm): ");
            personData[i][1] = input.nextInt()/100.0;
            personData[i][2] = personData[i][0]/(personData[i][1]*personData[i][1]);
            if (personData[i][2] <= 18.4) weight_status[i] = "Underweight";
            else if (personData[i][2] > 18.4 && personData[i][2] <= 24.9) weight_status[i] = "Normal";
            else if (personData[i][2] > 24.9 && personData[i][2] <= 39.9) weight_status[i] = "Overweight";
            else weight_status[i] = "Obese";
        }

        for (int j = 0; j < persons; j++) {
            System.out.printf("\nPerson %d: \nWeight: %.2f\nHeight: %.2f\nBMI: %.2f\nWeight Status: %s",
                    (j+1), personData[j][0], personData[j][1], personData[j][2], weight_status[j]);
        }
        input.close();
    }
}
