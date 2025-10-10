import java.util.Scanner;

public class PosNegZero {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a Number: ");
        int n = input.nextInt();
        System.out.print(type(n));
    }
    public static int type(int num) {
        if (num > 0) return 1;
        else if (num == 0) return 0;
        else return -1;
    }
}
