import java.util.Scanner;

public class NaturalNumberSum {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a No: ");
        int n = input.nextInt();
        int sum1 = (n*(n+1))/2;
        System.out.printf("Formula Sum: %d\nRecursive Method Sum: %d", sum1, sum(n));
    }
    public static int sum (int num) {
        if (num == 0) return 0;
        else return num + sum(num -1);
    }
}
