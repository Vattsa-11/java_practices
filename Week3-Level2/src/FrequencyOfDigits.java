import java.util.Scanner;

public class FrequencyOfDigits {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Number: ");
        String number = input.next();
        int[] frequency = new int[10];
        long temp = Long.parseLong(number);
        while (temp > 0) {
            int rem =(int) (temp % 10);
            frequency[rem] += 1;
            temp /= 10;
        }
        for (int i = 0; i < frequency.length; i++){
            System.out.printf("\n%d : %d", i, frequency[i]);
        }
    }
}