import java.util.Scanner;

public class TextWordLength {
    public static int customLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (Exception e) {
        }
        return count;
    }
    
    public static String[] customSplit(String text) {
        String trimmed = text.trim();
        int len = customLength(trimmed);
        int spaceCount = 0;
        for (int i = 0; i < len; i++) {
            if (trimmed.charAt(i) == ' ') spaceCount++;
        }
        int wordCount = spaceCount + 1;
        int[] spaceIndexes = new int[spaceCount];
        int idx = 0;
        for (int i = 0; i < len; i++) {
            if (trimmed.charAt(i) == ' ') {
                spaceIndexes[idx++] = i;
            }
        }
        String[] words = new String[wordCount];
        int start = 0, wordIndex = 0;
        for (int i = 0; i < spaceCount; i++) {
            int end = spaceIndexes[i];
            words[wordIndex++] = trimmed.substring(start, end);
            start = end + 1;
        }
        words[wordIndex] = trimmed.substring(start, len);
        return words;
    }
    
    public static String[][] wordsWithLengths(String[] words) {
        String[][] result = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            int len = customLength(words[i]);
            result[i][1] = String.valueOf(len);
        }
        return result;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the complete text: ");
        String input = scanner.nextLine();
        String[] words = customSplit(input);
        String[][] wordsLengths = wordsWithLengths(words);
        System.out.println("\nWord\tLength");
        System.out.println("----\t------");
        for (int i = 0; i < wordsLengths.length; i++) {
            int length = Integer.parseInt(wordsLengths[i][1]);
            System.out.println(wordsLengths[i][0] + "\t" + length);
        }
        scanner.close();
    }
}