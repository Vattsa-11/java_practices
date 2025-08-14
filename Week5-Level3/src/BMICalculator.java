import java.util.Scanner;

public class BMICalculator {

    // Method to compute BMI and status given a 2D array of weight & height (in cm)
    public static String[][] computeBMIAndStatus(double[][] data) {
        String[][] results = new String[data.length][4];
        for (int i = 0; i < data.length; i++) {
            double weight = data[i][0]; // in kg
            double heightCm = data[i][1];
            double heightM = heightCm / 100.0; // convert height to meter
            double bmi = weight / (heightM * heightM);
            String status;
            if (bmi < 18.5) {
                status = "Underweight";
            } else if (bmi < 25) {
                status = "Normal";
            } else if (bmi < 30) {
                status = "Overweight";
            } else {
                status = "Obese";
            }
            
            // Populate the results: height, weight, BMI (formatted), status
            results[i][0] = String.format("%.2f", heightCm);    // height in cm
            results[i][1] = String.format("%.2f", weight);        // weight in kg
            results[i][2] = String.format("%.2f", bmi);           // BMI
            results[i][3] = status;
        }
        return results;
    }

    // Method to display the 2D array in a tabular format
    public static void displayResults(String[][] results) {
        System.out.println("Person\tHeight(cm)\tWeight(kg)\tBMI\t\tStatus");
        for (int i = 0; i < results.length; i++) {
            System.out.println((i+1) + "\t" + results[i][0] + "\t\t" + results[i][1] 
                    + "\t\t" + results[i][2] + "\t\t" + results[i][3]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[][] data = new double[10][2]; // 10 persons, 0-index: weight, 1-index: height (cm)

        // Input weight and height for 10 persons
        for (int i = 0; i < 10; i++) {
            System.out.println("Enter details for person " + (i + 1) + ":");
            System.out.print("Enter weight in kg: ");
            data[i][0] = scanner.nextDouble();
            System.out.print("Enter height in cm: ");
            data[i][1] = scanner.nextDouble();
        }

        // Compute BMI and status
        String[][] resultTable = computeBMIAndStatus(data);

        // Display results in tabular format
        System.out.println("\nResults:");
        displayResults(resultTable);
        
        scanner.close();
    }
}