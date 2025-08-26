import java.util.Random;

public class TeamHeightAnalysis {

    public static int[] generateRandomHeights(int players) {
        int[] heights = new int[players];
        Random rand = new Random();
        for (int i = 0; i < players; i++) {
            heights[i] = rand.nextInt(101) + 150; // 150–250 cm
        }
        return heights;
    }

    public static int sum(int[] arr) {
        int sum = 0;
        for (int num : arr) sum += num;
        return sum;
    }

    public static double mean(int[] arr) {
        return (double) sum(arr) / arr.length;
    }

    public static int min(int[] arr) {
        int min = arr[0];
        for (int num : arr) if (num < min) min = num;
        return min;
    }

    public static int max(int[] arr) {
        int max = arr[0];
        for (int num : arr) if (num > max) max = num;
        return max;
    }

    public static void main(String[] args) {
        int[] heights = generateRandomHeights(11);
        for (int i = 0; i < heights.length; i++)
            System.out.println("Player " + (i+1) + ": " + heights[i] + " cm");

        System.out.printf("Shortest: %d cm\n", min(heights));
        System.out.printf("Tallest: %d cm\n", max(heights));
        System.out.printf("Mean: %.2f cm\n", mean(heights));
    }
}

