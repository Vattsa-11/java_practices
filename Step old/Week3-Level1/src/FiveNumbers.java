import java.util.Scanner;

public class FiveNumbers {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        int[] array = new int[5];
        for (int i = 0; i < array.length; i++) {
            System.out.printf("Enter element %d: ",i+1);
            array[i] = input.nextInt();
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0) {
                System.out.printf("\nThe number %d is Positive.", array[i]);
                if (array[i] % 2 == 0) System.out.printf(" Even.");
                else System.out.printf(" Odd.");
            } else if (array[i] < 0) System.out.printf("\nThe number %d is Negative.", array[i]);
            else System.out.print("\nThe number is Zero.");
        }
        if (array[0] > array[array.length-1]) System.out.println("\nThe First element is greater than the Last element.");
        else if (array[0] < array[array.length-1]) System.out.print("\nThe First element is less than the Last element.");
        else System.out.print("\nThe First and Last element are equal.");
    }
}
