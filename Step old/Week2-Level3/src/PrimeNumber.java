import java.util.Scanner;

public class PrimeNumber {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Number: ");
        int num = input.nextInt();
        int count = 1;
        for (int i= 2; i < num;i++){
            if (num%i == 0) {
                count += 1;
            }
        }
        boolean isPrime = (count == 1);
        if (isPrime) System.out.println("The "+num+" is a Prime number.");
        else System.out.println("The "+num+" is Not a Prime number.");
    }
}
