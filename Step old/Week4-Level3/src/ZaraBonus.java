import java.util.Random;

public class ZaraBonus {

    public static int[][] generateEmployees(int count) {
        int[][] data = new int[count][2];
        Random r = new Random();
        for (int i = 0; i < count; i++) {
            data[i][0] = r.nextInt(90000) + 10000;
            data[i][1] = r.nextInt(10) + 1;
        }
        return data;
    }

    public static double[][] calculateBonuses(int[][] empData) {
        double[][] results = new double[empData.length][2];
        for (int i = 0; i < empData.length; i++) {
            double bonus = empData[i][1] > 5 ? 0.05 : 0.02;
            double bonusAmount = empData[i][0] * bonus;
            results[i][0] = empData[i][0] + bonusAmount;
            results[i][1] = bonusAmount;
        }
        return results;
    }

    public static void main(String[] args) {
        int[][] employees = generateEmployees(10);
        double[][] bonuses = calculateBonuses(employees);

        System.out.println("Emp\tOldSalary\tYears\tNewSalary\tBonus");
        for (int i = 0; i < employees.length; i++) {
            System.out.printf("%d\t%d\t\t%d\t%.2f\t\t%.2f\n", i+1,
                    employees[i][0], employees[i][1], bonuses[i][0], bonuses[i][1]);
        }
    }
}
