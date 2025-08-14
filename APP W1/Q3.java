import java.util.Scanner;

public class Q3 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a No: ");
        int num = input.nextInt();
        if (num % 3 == 0){
            System.out.printf("The number %d is divisible by 3!", num);
        } else {
            System.out.printf("The number %d is not divisible by 3!", num);
        }
        input.close();
    }
}
