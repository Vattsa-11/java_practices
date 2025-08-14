
import java.util.Scanner;

public class QuotientAndRemainder {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter 1st Number: ");
        int num1 = input.nextInt();
        System.out.println("Enter 2nd Number: ");
        int num2 = input.nextInt();
        int quotient = num1/num2;
        int remainder = num1%num2;
        System.out.println("The Quotient is "+quotient+" and Remainder is "+remainder+" of two numbers "+num1+" and  "+num2);
        input.close();
    }   
}
