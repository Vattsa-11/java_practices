import java.util.Scanner;

public class MeanHeight {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        double[] heights = new double[11];
        System.out.println("Enter Student Heights: ");
        for (int i = 0; i < 11; i++) {
            System.out.print("Height of Student " + (i+1) + ": ");
            heights[i] = input.nextDouble();
        }
        double sum = 0;
        for (int i = 0; i < 11; i++) {
            sum += heights[i];
        }
        double mean = sum/11.0;
        System.out.printf("Mean Height of Students: %.2f cm.", mean);
        input.close();
    }
}
