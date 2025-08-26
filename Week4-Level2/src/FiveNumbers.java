import java.util.Scanner;

public class FiveNumbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] array = new int[5];
        for (int i = 0; i < array.length; i++) {
            System.out.printf("Enter element %d: ",i+1);
            array[i] = input.nextInt();
        }
        for (int n : array){
            System.out.printf("The number %d is %s and %s\n", n, isPositive(n), isEven(n));
        }
        compare(array[0], array[4]);
    }
    public static String isPositive(int num){
        if (num > 0) return "Positive";
        else return "Negative";
    }
    public static String isEven(int num){
        if ( num % 2 == 0 ) return "Even";
        else return "Odd";
    }
    public static void compare(int n1, int n2){
        if (n1 > n2) System.out.println("The First element is greater than the Last element.");
        else if (n1 < n2) System.out.print("The First element is less than the Last element.");
        else System.out.print("The First and Last element are equal.");
    }
}
