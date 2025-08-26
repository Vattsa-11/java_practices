import java.util.Scanner;

public class Factorial {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Number for Factorial: ");
        int num = input.nextInt();
        int factorial = 1;
        while (num > 0) {
            factorial *= num;
            num -= 1;
        }
        System.out.println("Factorial: " + factorial);
        input.close();
    }
}
