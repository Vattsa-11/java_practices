import java.util.Scanner;
import java.util.Random;
public class ScoreCard {
    public static int[][] generatePCMScores(int numStudents) {
        int[][] scores = new int[numStudents][3];
        Random rand = new Random();
        for (int i = 0; i < numStudents; i++) {
            scores[i][0] = rand.nextInt(90) + 10;
            scores[i][1] = rand.nextInt(90) + 10;
            scores[i][2] = rand.nextInt(90) + 10;
        }
        return scores;
    }
    public static double[][] calculateStats(int[][] scores) {
        int numStudents = scores.length;
        double[][] stats = new double[numStudents][3]; // Total, Average, Percentage
        for (int i = 0; i < numStudents; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double average = total / 3.0;
            double percentage = (total / 300.0) * 100;
            stats[i][0] = Math.round(total * 100.0) / 100.0;
            stats[i][1] = Math.round(average * 100.0) / 100.0;
            stats[i][2] = Math.round(percentage * 100.0) / 100.0;
        }
        return stats;
    }
    public static String[] calculateGrades(double[][] stats) {
        int numStudents = stats.length;
        String[] grades = new String[numStudents];
        for (int i = 0; i < numStudents; i++) {
            double per = stats[i][2];
            if (per >= 80.00)
                grades[i] = "Level 4, above agency-normalized standards";
            else if (per > 70.00)
                grades[i] = "Level 3, at agency-normalized standards";
            else if (per > 60.00)
                grades[i] = "Level 2, but approaching agency-normalized standards";
            else if (per > 50.00)
                grades[i] = "Level 1, well below agency-normalized standards";
            else if (per > 40.00)
                grades[i] = "Level 1-, too below agency-normalized standards";
            else
                grades[i] = "Remedial Standards";
        }
        return grades;
    }
    public static void displayScoreCard(int[][] scores, double[][] stats, String[] grades) {
        System.out.println("Student\tPhysics\tChemistry\tMaths\tTotal\tAverage\tPercentage\t\tGrade");
        System.out.println("-----------------------------------------------------------------------------------------");
        for (int i = 0; i < scores.length; i++) {
            System.out.println((i + 1) + "\t" + scores[i][0] + "\t" + scores[i][1] + "\t\t" + scores[i][2] + "\t" + stats[i][0] + "\t" + stats[i][1] + "\t" + stats[i][2] + "\t\t" + grades[i]);
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter No of Students: ");
        int num = input.nextInt();
        int[][] scores = generatePCMScores(num);
        double[][] stats = calculateStats(scores);
        String[] grades = calculateGrades(stats);
        displayScoreCard(scores, stats, grades);
        input.close();
    }
}