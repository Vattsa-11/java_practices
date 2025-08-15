import java.util.Scanner;

public class Q4 {
    public static int[] frequency(String s) {
        int[] frequency = new int[256];
        for (int i =0; i < s.length(); i++) {
            char ch = s.charAt(i);
            frequency[ch]++;
        }
        return frequency;
    }
    public static int[][] return2d(int[] frequency) {
        int [][] arr = new int[frequency.length][2];
        // int cnt = 0;
        for (int i =0; i < frequency.length; i++){
            if (frequency[i] != 0) {
                arr[i][0] = i;
                arr[i][1] = frequency[i];
            }
        }
        return arr;
    }
    public static void display(int[][] arr) {
        System.out.printf("%s\t\t%s", "Character", "Frequency");
        System.out.println("\n");
        for (int i = 0; i < arr.length; i++) {
            char character = (char) arr[i][0];
            int freq = arr[i][1];
            String charDisplay = String.valueOf(character);
            System.out.printf("'%s'\t\t\t%d\n", charDisplay, freq);
        }
    }
    public static void main(String[] args) {

    }
}
