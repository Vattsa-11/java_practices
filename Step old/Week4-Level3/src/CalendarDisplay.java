import java.util.Scanner;

public class CalendarDisplay {

    public static String getMonthName(int month) {
        String[] months = { "", "January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December" };
        return months[month];
    }

    public static int getDaysInMonth(int month, int year) {
        int[] days = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        if (month == 2 && isLeapYear(year)) return 29;
        return days[month];
    }

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }

    public static int getFirstDayOfMonth(int month, int year) {
        int d = 1;
        int y0 = year - (14 - month) / 12;
        int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
        int m0 = month + 12 * ((14 - month) / 12) - 2;
        return (d + x + 31 * m0 / 12) % 7;
    }

    public static void printCalendar(int month, int year) {
        System.out.println("\n  " + getMonthName(month) + " " + year);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");

        int startDay = getFirstDayOfMonth(month, year);
        int totalDays = getDaysInMonth(month, year);

        for (int i = 0; i < startDay; i++) System.out.print("    ");
        for (int i = 1; i <= totalDays; i++) {
            System.out.printf("%3d ", i);
            if ((i + startDay) % 7 == 0) System.out.println();
        }
    }

    public static void main(String[] args) {
        printCalendar(7, 2005);
    }
}
