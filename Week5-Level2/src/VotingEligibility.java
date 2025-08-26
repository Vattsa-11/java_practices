import java.util.Scanner;
import java.util.Random;
public class VotingEligibility {
    public static int[] generateRandomAges(int n) {
        int[] ages = new int[n];
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            ages[i] = rand.nextInt(90) + 10;
        }
        return ages;
    }
    public static String[][] getVotingEligibility(int[] ages) {
        String[][] result = new String[ages.length][2];
        for (int i = 0; i < ages.length; i++) {
            result[i][0] = String.valueOf(ages[i]);
            if (ages[i] < 0) {
                result[i][1] = "false";
            } else if (ages[i] >= 18) {
                result[i][1] = "true";
            } else {
                result[i][1] = "false";
            }
        }
        return result;
    }
    public static void displayTable(String[][] array) {
        System.out.println("Age\tCan Vote");
        System.out.println("-----------------");
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i][0] + "\t" + array[i][1]);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int n = scanner.nextInt();
        int[] ages = generateRandomAges(n);
        String[][] eligibility = getVotingEligibility(ages);
        displayTable(eligibility);
        scanner.close();
    }
}