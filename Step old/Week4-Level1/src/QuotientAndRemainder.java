import java.util.Scanner;

public class QuotientAndRemainder {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter No: ");
        int num = input.nextInt();
        System.out.print("Enter Divisor: ");
        int div = input.nextInt();
        int[] arr = findRemainderAndQuotient(num, div);
        System.out.printf("Quotient: %d, Remainder: %d", arr[0], arr[1]);
    }
    public static int[] findRemainderAndQuotient(int number , int divisor) {
        int quotient, remainder;
        quotient = number / divisor;
        remainder = number % divisor;
        return new int[]{quotient, remainder};
    }
}
