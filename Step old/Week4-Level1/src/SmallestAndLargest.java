import java.util.Scanner;

public class SmallestAndLargest {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        int[] arr ;
        System.out.print("Enter 1st No: ");
        int n1 = input.nextInt();
        System.out.print("Enter 2nd No: ");
        int n2 = input.nextInt();
        System.out.print("Enter 3rd No: ");
        int n3 = input.nextInt();
        arr = findSmallestAndLargest(n1, n2, n3);
        System.out.printf("Largest: %d, Smallest: %d", arr[1], arr[0]);
    }
    public static int[] findSmallestAndLargest(int number1, int number2, int number3){
        int smallest = 0, largest = 0;
        largest = (Math.max(number1, number2));
        largest = Math.max(largest, number3);
        smallest = Math.min(number1, number2);
        smallest = Math.min(smallest, number3);
        return new int[]{smallest, largest};
    }
}
