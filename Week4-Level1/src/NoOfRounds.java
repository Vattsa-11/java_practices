import java.util.Scanner;

public class NoOfRounds {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter distance for side 1(m): ");
        int side1 = input.nextInt();
        System.out.print("Enter distance for side 2(m): ");
        int side2 = input.nextInt();
        System.out.print("Enter distance for side 3(m): ");
        int side3 = input.nextInt();

        rounds(side1, side2, side3);
    }
    public static void rounds(int s1, int s2, int s3) {
        int total = s1 + s2 + s3;
         float r = ((float) 5000 / total);
        System.out.printf("No of rounds to run: %.2f", r);

    }
}
