import java.util.Scanner;

public class SumAndFormulaForLoop {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a Number: ");
        int num = input.nextInt();
        int total = num*(num+1)/2;
        int sum = 0;
        for (int i = num; i > 0; i--) {
            sum += i;
        }
        System.out.println("The sum by while loop "+sum+" and total by formula "+total+" is same.");
        input.close();
    }
}
