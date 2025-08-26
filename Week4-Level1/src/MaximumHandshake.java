import java.util.Scanner;

public class MaximumHandshake {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter total No of students: ");
        int num = input.nextInt();
        maxHandshakes(num);
    }
    public static void maxHandshakes(int n) {
        System.out.println("Total no of Handshakes: "+ ((n*(n-1)))/2);
    }
}
