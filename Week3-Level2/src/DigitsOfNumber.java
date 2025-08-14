import java.util.Scanner;

public class DigitsOfNumber {
    public static void main (String [] args) {
        Scanner input = new Scanner(System.in);
        int maxDigit = 10, index = 0, num;
        int[] array = new int[maxDigit];
        System.out.print("Enter a Num: ");
        num = input.nextInt();
        int temp = num;
        while (temp > 0) {
            if (index == maxDigit) break;
            int rem = temp % 10;
            array[index++] = rem;
            temp -= rem;
            temp /= 10;
        }
        int largest = 0, second_largest = 0;
        for (int i = 0; i < index; i++) {
            if (array[i] > largest) largest = array[i];
            if (array[i] < largest && array[i] > second_largest) second_largest = array[i];
        }
        System.out.println("Largest: " + largest);
        System.out.println("Second Largest: " + second_largest);
    }
}
