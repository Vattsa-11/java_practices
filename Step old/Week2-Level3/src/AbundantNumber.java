import java.util.Scanner;

public class AbundantNumber {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a Number: ");
        int num = input.nextInt();
        int divSum = 0;
        for (int i = 1; i<num; i++) {
            if (num % i == 0) {
                divSum += i;
            }
        }
        if (divSum > num) System.out.print("The num "+ num +" is a Abundant Number.");
        else System.out.print("The num "+ num + " is not a Abundant Number.");
    }
}
