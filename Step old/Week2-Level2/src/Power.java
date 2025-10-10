import java.util.Scanner;

public class Power {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number: ");
        int num = input.nextInt();
        System.out.print("Enter power: ");
        int pow = input.nextInt();
        int temp = 1;
        for (int i = 1;i<= pow;i++) {
            temp = temp*num;
        }
        System.out.print(temp);
        input.close();
    }
}
