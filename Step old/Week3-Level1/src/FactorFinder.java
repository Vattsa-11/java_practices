import java.util.Scanner;

public class FactorFinder {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        int maxFactor = 10;
        int[] factors = new int[maxFactor];
        System.out.print("Enter a Number: ");
        int num = input.nextInt();
        int index = 0;
        for (int i = 1; i < num; i++) {
            if (num % i == 0) {
                if (index == maxFactor) {
                    maxFactor *= 2;
                    int[] temp = new int[maxFactor];
                    for (int j = 0; j < index; j++) {
                        temp[j] = factors[j];
                    }
                    factors = temp;
                }
                factors[index++] = i;
            }
        }
        System.out.print("Factor of " + num + " are. ");
        for (int j = 0; j < factors.length; j++) {
            if (factors[j] == 0) break;
            System.out.print(factors[j]+" ");
        }
    }
}
