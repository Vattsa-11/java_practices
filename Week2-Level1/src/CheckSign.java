import java.util.Scanner;

public class CheckSign {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a Number: ");
        int num = input.nextInt();
        if (num > 0) {
            System.out.print("The number is positive.");
        } else if (num < 0) {
            System.out.print("The number is negative.");
        } else {
            System.out.print("The number is zero.");
        }
        input.close();
    }
}
