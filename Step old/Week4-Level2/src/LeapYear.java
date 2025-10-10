import java.util.Scanner;

public class LeapYear {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Year: ");
        int y = input.nextInt();
        if (isLeapYear(y)) System.out.printf("The year %d is a leap year.", y);
        else System.out.printf("The year %d is  not a leap year.", y);
    }
    public static boolean isLeapYear(int year) {
        return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
    }
}
