import java.util.Scanner;

public class OddAndEven {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = input.nextInt();
        int size  = (number / 2) + 1;
        int[] evenArray = new int[size];
        int[] oddArray = new int[size];
        int oddIndex = 0, evenIndex = 0;
        for (int i = 1; i <= number; i++) {
            if (i % 2 == 0) {
                evenArray[evenIndex] = i;
                evenIndex++;
            } else {
                oddArray[oddIndex] = i;
                oddIndex++;
            }
        }
        for (int j = 0; j < oddIndex; j++) System.out.print(oddArray[j]+ " ");
        System.out.print("\n");
        for (int k = 0; k < evenIndex; k++) System.out.print(evenArray[k] + " ");
    }
}
