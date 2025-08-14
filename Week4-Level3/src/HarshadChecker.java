public class HarshadChecker {

    public static int[] getDigits(int number) {
        return NumberChecker.getDigits(number);
    }

    public static boolean isHarshad(int number) {
        int[] digits = getDigits(number);
        int sum = 0;
        for (int d : digits) sum += d;
        return number % sum == 0;
    }

    public static int sumOfSquares(int[] digits) {
        int sum = 0;
        for (int d : digits) sum += d * d;
        return sum;
    }

    public static int[][] digitFrequency(int[] digits) {
        int[][] freq = new int[10][2];
        for (int i = 0; i < 10; i++) freq[i][0] = i;
        for (int d : digits) freq[d][1]++;
        return freq;
    }

    public static void main(String[] args) {
        int number = 21;
        int[] digits = getDigits(number);

        System.out.println("Harshad: " + isHarshad(number));
        System.out.println("Sum of squares: " + sumOfSquares(digits));
        int[][] freq = digitFrequency(digits);
        for (int[] row : freq)
            if (row[1] > 0) System.out.println(row[0] + ": " + row[1]);
    }
}
