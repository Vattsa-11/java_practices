import java.util.Scanner;

public class ReverseNumber {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a Number: ");
        int num = input.nextInt();
        int count = 0;
        int temp = num;
        while (temp > 0) {
            count += 1;
            int rem = temp % 10;
            temp -= rem;
            temp /= 10;
        }
        int[] reverse = new int[count];
        for (int i = 0; i < count; i++) {
            int rem = num % 10;
            reverse[i] = rem;
            num -= rem;
            num /= 10;
        }
        for (int j = 0; j < count; j++) {
            System.out.print(reverse[j]);
        }
    }
}
