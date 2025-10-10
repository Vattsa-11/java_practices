import java.util.Scanner;

public class Bonus {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double[] salary = new double[10];
        double[] years = new double[10];
        double totalBonus = 0, totalOld = 0, totalNew = 0, bonus;
        double[] newSalary = new double[10];
        int index = 10;
        for (int i = 0; i < index; i++) {
            System.out.print("Enter salary for employee " + (i + 1)+ ": ");
            salary[i] = input.nextDouble();
            System.out.print("Enter years of experience for employee "+ (i + 1)+ ": ");
            years[i] = input.nextDouble();
            if (years[i] < 0) {
                System.out.print("Invalid year, Please enter again");
                years[i] = input.nextDouble();
            }
        }
        for (int j = 0; j < index; j++) {
            if (years[j] >= 5) {
                bonus = salary[j]*0.05;
            } else {
                bonus = salary[j]*0.02;
            }
            totalBonus += bonus;
            newSalary[j] = salary[j] + bonus;
        }
        for (int k = 0; k < index; k++) {
            totalOld += salary[k];
            totalNew += newSalary[k];
        }
        System.out.println("Total Bonus: "+ totalBonus);
        System.out.println("Total Old: " + totalOld);
        for (int l = index-1; l >= 0; l--) {
            System.out.println("Salary of Employee " + (l + 1) +": "+newSalary[l]);
        }
        System.out.println("Total New: "+ totalNew);
        input.close();
    }
}