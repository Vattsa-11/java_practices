import java.util.Arrays;
import java.util.Scanner;

public class UniqueCharacter {
    static Scanner input = new Scanner(System.in);

    public static int lengthfinder(String s) {
         int count = 0;
        try {
            while (true) {
                s.charAt(count);
                count++;
            }
        } catch (IndexOutOfBoundsException e) {
            return count;
        }
    }

    public static String[] UniqCharacter(String s) {
        String str = s.toLowerCase();
        String[] chars = new String[lengthfinder(str)];
        int index = 0;
        for (int i = 0; i < str.length(); i++) {
            String currentChar = String.valueOf(str.charAt(i));
            if (!Arrays.asList(chars).contains(currentChar) && !Character.isAlphabetic(str.charAt(i))) {
                chars[index] = currentChar;
                index++;
            }
        }
        return chars;
    }
    public static void main(String[] args) {
        System.out.print("Enter a string: ");
        String s = input.nextLine();
        String[] uniqueChars = UniqCharacter(s);
        System.out.println("Unique Characters:");
        for (String character : uniqueChars) {
            if (character != null) {
                System.out.printf("%s  ", character);
            }
        }
        input.close();
    }
}
