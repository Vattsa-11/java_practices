import java.util.Scanner;

public class NaturalNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a Number: ");
        int num = input.nextInt();
        if (num > 0) {
            int sum = num*(num+1)/2;
            System.out.println("The sum of " + num + " natural numbers is: " + sum + ".");
        } else {
            System.out.println("The number " + num + " is not a natural number.");
        }
    }
}
