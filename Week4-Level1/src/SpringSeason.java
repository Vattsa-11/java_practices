import java.util.Scanner;

public class SpringSeason {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the Month: ");
        int month = input.nextInt();
        System.out.print("Enter the Day: ");
        int day = input.nextInt();
        System.out.print(yesOrNo(month, day));
    }
    public static String yesOrNo(int m, int d) {
        if ((m == 3 && d > 20) || (m == 6 && d < 20) || (m > 3 && m < 6)) {
            return "Its Spring Season.";
        } else {
            return "Its not Spring Season";
        }
    }
}
