import java.util.Scanner;

public class StudentVoteChecker {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        int[] students = {18, 10, 1, -3, 27, 40, 17, 20, 19, 33};
        for (int i : students) {
            if (canStudentVote(i)) System.out.printf("Student of age %d can Vote.\n", i);
            else System.out.printf("Student of age %d cannot Vote.\n", i);
        }
    }
    public static boolean canStudentVote(int age) {
        if (age > 0) return age >= 18;
        else return false;
    }
}
