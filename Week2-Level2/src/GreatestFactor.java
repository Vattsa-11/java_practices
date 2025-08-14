import java.util.Scanner;

public class GreatestFactor {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a Number: ");
        int num = input.nextInt();
        int greatestFactor = 1;
        for (int i = num-1; i>0; i--) {
            if (num % i == 0){
                greatestFactor = i;
                break;
            }
        }
        System.out.print("The Greatest Factor of "+num+" is "+greatestFactor);
        input.close();
    }
}
