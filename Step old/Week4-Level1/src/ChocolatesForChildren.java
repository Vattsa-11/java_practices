import java.util.Scanner;

public class ChocolatesForChildren {

    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter No of Chocolates: ");
        int noOfChocolates = input.nextInt();
        System.out.print("Enter No of Children: ");
        int noOfChildren = input.nextInt();
        int[] arr = findRemainderAndQuotient(noOfChocolates, noOfChildren);
        System.out.printf("Each child will get %d chocolates, and %d will be remaining.", arr[0], arr[1]);
    }
    public static int[] findRemainderAndQuotient(int number , int divisor) {
        int quotient, remainder;
        quotient = number / divisor;
        remainder = number % divisor;
        return new int[]{quotient, remainder};
    }
}

