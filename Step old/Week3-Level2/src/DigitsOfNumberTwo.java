import java.util.Scanner;

public class DigitsOfNumberTwo {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        int maxDigit = 10, index = 0, num;
        int[] array = new int[maxDigit];
        System.out.print("Enter a Num: ");
        num = input.nextInt();
        int temp = num;
        while (temp > 0) {
            if (index == maxDigit) {
                maxDigit *= 2;
                int[] temp_array = new int[maxDigit];
                for (int j = 0; j < index; j++) {
                    temp_array[j] = array[j];
                }
                array = temp_array;
            }
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
