import java.util.Scanner;

public class YoungestAndTallest {
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);
        int[] amar = new int[3];
        int[] akbar = new int[3];
        int[] anthony = new int[3];

        System.out.print("Enter 3 Ages: ");
        amar[0] = input.nextInt();
        akbar[0] = input.nextInt();
        anthony[0] = input.nextInt();

        System.out.print("Enter 3 Heights: ");
        amar[1] = input.nextInt();
        akbar[1] = input.nextInt();
        anthony[1] = input.nextInt();

        if (amar[0] < akbar[0] && amar[0] < anthony[0]) {
            System.out.println("The youngest person is Amar, "+amar[0]);
        } else if (akbar[0] < amar[0] && akbar[0] < anthony[0]) {
            System.out.println("The youngest person is Akbar, "+akbar[0]);
        } else {
            System.out.println("The youngest person is Anthony, "+anthony[0]);
        }

        if (amar[1] > akbar[1] && amar[1] > anthony[1]) {
            System.out.println("The tallest person is Amar,"+amar[1]);
        } else if (akbar[1] > amar[1] && akbar[1] > anthony[1]) {
            System.out.println("The tallest person is Akbar, "+akbar[1]);
        } else {
            System.out.println("The tallest person is Anthony, "+anthony[1]);
        }
        input.close();
    }
}
