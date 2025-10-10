import java.util.Scanner;

public class HarshadNumber {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a Number: ");
        int num = input.nextInt();
        int sum = 0;
        int temp = num;
        while (temp > 0){
            int rem = temp % 10;
            sum += rem;
            temp -= rem;
            temp /= 10;
        }
        if (num % sum == 0) System.out.print("The num "+ num +" is a Harshad Number.");
        else System.out.print("The num "+ num + " is not a Harshad Number.");
    }
}
