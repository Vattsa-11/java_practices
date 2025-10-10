import java.util.Scanner;

public class NaturalNumberSum {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a Number: ");
        int num = input.nextInt();
        if (num < 0) System.out.print("Invalid Number!");
        else System.out.print("Sum of " + num + " Natural Number is: " + sum(num));
    }
    public static int sum(int n){
        int sum = 0;
        for (int i = 1; i < n+1; i++) {
            sum += i;
        }
        return sum;
    }
}
