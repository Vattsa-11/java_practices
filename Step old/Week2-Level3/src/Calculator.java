import java.util.Scanner;

public class Calculator {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number 1: ");
        double first = input.nextDouble();
        System.out.print("Enter number 2: ");
        double second = input.nextDouble();
        System.out.print("Enter operator: ");
        String op = input.next();
        switch (op) {
            case "+":
                System.out.print("Addition: "+(first+second));
                break;
            case "-":
                System.out.print("Subtraction: "+(first-second));
                break;
            case "x":
                System.out.print("Multiplication: "+(first*second));
                break;
            case "/":
                System.out.print("Division: "+(first/second));
                break;
            default:
                System.out.print("Invalid Operator.");
                break;
        }
    }
}