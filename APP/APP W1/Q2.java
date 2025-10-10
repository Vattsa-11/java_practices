import java.util.Scanner;

public class Q2 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a No: ");
        int num = input.nextInt();
        if (num % 2 == 0){
            System.out.println("The number is Even!");
        } else {
            System.out.println("The number is Odd!");
        }
        input.close();
    }
}
