import java.util.Scanner;

public class CanVote {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        int[] students = new int[10];
        for (int i =0; i< students.length; i++) {
            System.out.printf("Enter age of Student %d: ", (i+1));
            students[i] = input.nextInt();
        }
        for (int i =0; i< students.length; i++) {
            if (students[i] < 0) System.out.println("Invalid Age.");
            else if (students[i] >= 18) System.out.printf("The Student %d with the age %d can vote.\n", (i+1), students[i]);
            else System.out.printf("The Student %d with the age %d cannot vote.\n", (i+1), students[i]);
        }
    }
}
