public class StudentScorecard {

    public static int[][] generateMarks(int students) {
        int[][] marks = new int[students][3];
        for (int i = 0; i < students; i++) {
            for (int j = 0; j < 3; j++) {
                marks[i][j] = (int)(Math.random() * 41 + 60); // Random 2-digit
            }
        }
        return marks;
    }

    public static double[][] evaluate(int[][] marks) {
        double[][] results = new double[marks.length][3];
        for (int i = 0; i < marks.length; i++) {
            int total = marks[i][0] + marks[i][1] + marks[i][2];
            results[i][0] = total;
            results[i][1] = total / 3.0;
            results[i][2] = (total / 300.0) * 100;
        }
        return results;
    }

    public static void main(String[] args) {
        int[][] marks = generateMarks(5);
        double[][] results = evaluate(marks);

        System.out.println("Stu\tP\tC\tM\tTotal\tAvg\t\tPercent");
        for (int i = 0; i < marks.length; i++) {
            System.out.printf("%d\t%d\t%d\t%d\t%.0f\t%.2f\t%.2f%%\n", i+1,
                    marks[i][0], marks[i][1], marks[i][2],
                    results[i][0], results[i][1], results[i][2]);
        }
    }
}
