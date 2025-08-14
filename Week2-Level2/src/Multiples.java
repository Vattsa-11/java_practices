import java.util.Scanner;

public class Multiples {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a Number: ");
        int num = input.nextInt();
        for (int i = num; i>0; i--) {
            if (num % i == 0){
                System.out.println(i);
            }
        }
        input.close();
    }
}
