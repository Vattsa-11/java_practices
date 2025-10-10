import java.util.Scanner;

public class DigitCounter {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a Number: ");
        int num = input.nextInt();
        int count = 0;
        while (num > 0) {
            count += 1;
            int rem = num % 10;
            num -= rem;
            num /= 10;
        }
        System.out.print("The no of Digits: " + count);
    }
}