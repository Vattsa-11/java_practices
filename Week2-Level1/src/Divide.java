import java.util.Scanner;

public  class Divide {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a Number: ");
        int number = input.nextInt();
        if (number % 5 == 0) {
            System.out.println("The number is divisible  by 5");
        }
        input.close();
    }
}