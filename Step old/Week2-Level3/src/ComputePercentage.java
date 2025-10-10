import java.util.Scanner;

public class ComputePercentage {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter physics mark: ");
        int phy = input.nextInt();
        System.out.print("Enter chemistry mark: ");
        int chm = input.nextInt();
        System.out.print("Enter maths mark: ");
        int math = input.nextInt();
        double percentage = (double)(phy+chm+math)/3.0;
        System.out.printf("%.2f%%", percentage);
        System.out.println();
        if (percentage >= 80.00) System.out.println("Level 4, above agency-normalized standards");
        else if (percentage > 70.00) System.out.println("Level 3, at agency-normalized standards");
        else if (percentage > 60.00) System.out.println("Level 2, but approaching agency-normalized standards");
        else if (percentage > 50.00) System.out.println("Level 1, well below agency-normalized standards");
        else if (percentage > 40.00) System.out.println("Level 1-, too below agency-normalized standards");
        else System.out.println("Remedial Standards");
    }
}
