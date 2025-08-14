import java.util.Scanner;

public class BMI {
    public static void main(String[] args){
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
        }
        calculateBMI(personData, weight_status);
        displayBMI(personData, weight_status);
        input.close();
    }
    public static void calculateBMI(double[][] data, String[] weight){
        for (int i = 0; i< data.length; i++){
            if (data[i][2] <= 18.4) weight[i] = "Underweight";
            else if (data[i][2] > 18.4 && data[i][2] <= 24.9) weight[i] = "Normal";
            else if (data[i][2] > 24.9 && data[i][2] <= 39.9) weight[i] = "Overweight";
            else weight[i] = "Obese";
        }
    }
    public static void displayBMI(double[][] data, String[] wt){
        for (int j = 0; j < data.length; j++) {
            System.out.printf("\nPerson %d: \nWeight: %.2f\nHeight: %.2f\nBMI: %.2f\nWeight Status: %s",
                    (j+1), data[j][0], data[j][1], data[j][2], wt[j]);
        }
    }
}
