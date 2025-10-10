import java.util.Scanner;

public class PrintingOddAndEven {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Please Enter a number: ");
        int num = input.nextInt();
        if (num <= 0) {
            System.out.println("Please  enter a natural number");
        } else {
            for(int i=1; i<= num; i++) {
                if (i%2 == 0) {
                    System.out.println(i+" its even");
                } else {
                    System.out.println(i+" its odd");
                }
            }
        }
        input.close();
    }
}