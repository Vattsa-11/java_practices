import java.util.Scanner;

public class FactorialForLoop {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Number for Factorial: ");
        int num = input.nextInt();
        int factorial = 1;
        for (int i = num; i>0; i--) {
            factorial *= i;
        }
        System.out.println("Factorial: " + factorial);
        input.close();
    }
}
