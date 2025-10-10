import java.util.Scanner;

public class Counter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Countdown value: ");
        int num = input.nextInt();

        while (num > 0) {
            System.out.println(num);
            num -= 1;
        }
        input.close();
    }
}
