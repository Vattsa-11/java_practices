import java.util.Scanner;

public class Largest {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter 3 Numbers: ");
        int num1 = input.nextInt();
        int num2 = input.nextInt();
        int num3 = input.nextInt();
        if (num1 > num2 && num1 > num3) {
            System.out.println("Is the first number the largest? Yes.");
            System.out.println("Is the second number the largest? No.");
            System.out.println("Is the third number the largest? No.");
        } else if (num1 < num2 && num2 > num3) {
            System.out.println("Is the first number the largest? No.");
            System.out.println("Is the second number the largest? Yes.");
            System.out.println("Is the third number the largest? No.");
        } else {
            System.out.println("Is the first number the largest? No.");
            System.out.println("Is the second number the largest? No.");
            System.out.println("Is the third number the largest? Yes.");
        }

        input.close();
    }
}
