import java.util.Scanner;

public class DayOfWeek {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter month: ");
        int m = input.nextInt();
        System.out.print("Enter day: ");
        int d = input.nextInt();
        System.out.print("Enter year: ");
        int y = input.nextInt();
        int y_0 = y-(14-m)/12;
        int x = y_0 + (y_0/4) - (y_0/100) + (y_0/400);
        int m_0 = m + 12*((14-m)/12) - 2;
        int d_0 = (d + x + 31*m_0/12) % 7;

        System.out.print("Day of the Week: "+ d_0);
        input.close();
    }
}
