import java.util.Scanner;

public class Sum {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Number to Add: ");
        int number = input.nextInt();
        double total = 0.0;
        while (number != 0) {
            total += number;
            System.out.print("Enter Number to Add: ");
            number = input.nextInt();
        }
        System.out.println("Sum: "+total);
        input.close();
    }
}
