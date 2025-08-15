import java.util.Scanner;

public class UniqueCharacter {
    public static int[] frequency(String s) {
        String str = s.toLowerCase();
        int[] frequency = new int[256];
        for (int i =0; i < str.length(); i++) {
            char ch = str.charAt(i);
            frequency[ch]++;
        }
        return frequency;
    }
    public static void displayUniqueCharacters(int[] frequency) {
        System.out.println("Unique Characters:");
        for (int i = 0; i < frequency.length; i++) {
            if (frequency[i] == 1) {
                char character = (char) i;
                System.out.printf("'%s'\n", character);
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String s = input.nextLine();
        int[] f = frequency(s);
        displayUniqueCharacters(f);
        input.close();

    }
}

