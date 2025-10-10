import java.util.Scanner;

public class BMICalculation {

    static Scanner input = new Scanner(System.in);
    public static double[][] getData(double[][] data) {
        double[][] bmi = new double[10][3];
        for (int i = 0; i < 10; i++) {
            System.out.print("Enter weight (kg) for person " + (i + 1) + ": ");
            data[i][0] = input.nextDouble();
            System.out.print("Enter height (cm) for person " + (i + 1) + ": ");
            data[i][1] = input.nextDouble();
            
            double heightM = data[i][1] / 100;
            double bmiValue = data[i][0] / (heightM * heightM);
            bmi[i][0] = data[i][0]; // weight
            bmi[i][1] = data[i][1];
            bmi[i][2] = bmiValue;
        }
        return bmi;
    }
    
    public static String[][] getStatus(double[][] bmi) {
        String[][] data = new String[10][4];
        for (int i = 0; i < 10; i++) {
            data[i][0] = String.format("%.2f", bmi[i][0]);
            data[i][1] = String.format("%.2f", bmi[i][1]);
            data[i][2] = String.format("%.2f", bmi[i][2]);
            if (bmi[i][2] <= 18.4) {
                data[i][3] = "Underweight";
            } else if (bmi[i][2] >= 18.5 && bmi[i][2] <= 24.9) {
                data[i][3] = "Normal";
            } else if (bmi[i][2] >= 25.0 && bmi[i][2] <= 39.9) {
                data[i][3] = "Overweight";
            } else {
                data[i][3] = "Obese";
            }
        }
        return data;
    }
    public static void displayResults(String[][] results) {
        System.out.printf("%s\t\t%s\t\t%s\t\t%s\n", "Person", "Weight(kg)", "Height(cm)", "BMI", "Status");
        for (int i = 0; i < 10; i++) {
            System.out.printf("%d\t\t%s\t\t%s\t\t%s\t\t%s\n", 
                i + 1, results[i][0], results[i][1], results[i][2], results[i][3]);
        }
    }
    public static void main(String[] args){
        System.out.println("BMI Calculation for 10 Persons");
        double[][] data = new double[10][3]; 
        displayResults(getStatus(getData(data)));
        input.close();
    }
}
