import java.util.Scanner;

public class ComputePercentage2d {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter No of Students: ");
        int num = input.nextInt();
        int[][] marks = new int[num][3];
        double[] percentage = new double[num];
        for (int i = 0; i < num; i++) {
            System.out.print("Enter physics mark: ");
            marks[i][0] = input.nextInt();
            System.out.print("Enter chemistry mark: ");
            marks[i][1] = input.nextInt();
            System.out.print("Enter maths mark: ");
            marks[i][2] = input.nextInt();
            if (marks[i][0] < 0) {
                System.out.print("Enter positive values (phy): ");
                marks[i][0] = input.nextInt();
            } else if (marks[i][1] < 0) {
                System.out.print("Enter positive values (chm): ");
                marks[i][1] = input.nextInt();
            } else if (marks[i][2] < 0) {
                System.out.print("Enter positive values (mat): ");
                marks[i][2] = input.nextInt();
            }
            percentage[i] = (double) (marks[i][0] + marks[i][1] + marks[i][2]) / 3.0;
        }
        System.out.println();
        for (int j = 0; j < num; j++){
            if (percentage[j] >= 80.00) System.out.println("Level 4, above agency-normalized standards");
            else if (percentage[j] > 70.00) System.out.println("Level 3, at agency-normalized standards");
            else if (percentage[j] > 60.00) System.out.println("Level 2, but approaching agency-normalized standards");
            else if (percentage[j] > 50.00) System.out.println("Level 1, well below agency-normalized standards");
            else if (percentage[j] > 40.00) System.out.println("Level 1-, too below agency-normalized standards");
            else System.out.println("Remedial Standards");
        }
        input.close();
    }
}
