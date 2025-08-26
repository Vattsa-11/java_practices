import java.util.Scanner;

public class ComputePercentage {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter No of Students: ");
        int num = input.nextInt();
        int[] phy = new int[num];
        int[] chm = new int[num];
        int[] mat = new int[num];
        double[] percentage = new double[num];
        for (int i = 0; i < num; i++) {
            System.out.print("Enter physics mark: ");
            phy[i] = input.nextInt();
            System.out.print("Enter chemistry mark: ");
            chm[i] = input.nextInt();
            System.out.print("Enter maths mark: ");
            mat[i] = input.nextInt();
            if (phy[i] < 0) {
                System.out.print("Enter positive values (phy): ");
                phy[i] = input.nextInt();
            } else if (chm[i] < 0) {
                System.out.print("Enter positive values (chm): ");
                chm[i] = input.nextInt();
            } else if (mat[i] < 0) {
                System.out.print("Enter positive values (mat): ");
                mat[i] = input.nextInt();
            }
            percentage[i] = (double) (phy[i] + chm[i] + mat[i]) / 3.0;
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
