import java.util.Scanner;

public class FizzBuzz {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a Number: ");
        int num = input.nextInt();
        if (num > 0) {
            int count = 0;
            String[] array = new String[num];
            for (int i = 1; i <= num; i++) {
                if (i % 3 == 0 && i % 5 ==0) array[count++] = "FizzBuzz";
                else if (i % 3 == 0) array[count++] = "Fizz";
                else if (i % 5 == 0) array[count++] = "Buzz";
                else array[count++] = String.valueOf(i);
            }
            for (int j = 0; j < num; j++) System.out.print(array[j] + " ");
        }
        input.close();
    }
}
