import java.util.Scanner;

public class SpringSeason {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Month: ");
        int month = input.nextInt();
        System.out.print("Enter Day: ");
        int day = input.nextInt();

        if ((month == 3 && day > 20) || (month == 6 && day < 20) || (month > 3 && month < 6)) {
            System.out.println("Its Spring Season.");
        } else {
            System.out.println(("Its not Spring Season"));
        }
    }
}
