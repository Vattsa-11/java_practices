import java.util.Scanner;
public class TextMinMaxLength {
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
    public static int[] findMinMax(String[][] wordLengths) {
        int minIdx = 0;
        int maxIdx = 0;
        for (int i = 0; i < wordLengths.length; i++) {
            int curr = Integer.parseInt(wordLengths[i][1]);
            int min = Integer.parseInt(wordLengths[minIdx][1]);
            int max = Integer.parseInt(wordLengths[maxIdx][1]);
            if (curr < min) minIdx = i;
            if (curr > max) maxIdx = i;
        }
        return new int[] { minIdx, maxIdx };
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the complete text: ");
        String input = scanner.nextLine();
        String[] words = customSplit(input);
        String[][] wordLengths = wordsWithLengths(words);
        int[] minMax = findMinMax(wordLengths);
        System.out.println("\nWord\tLength");
        System.out.println("--------------");
        for (int i = 0; i < wordLengths.length; i++) {
            System.out.println(wordLengths[i][0] + "\t" + Integer.parseInt(wordLengths[i][1]));
        }
        System.out.println("\nShortest word: " + wordLengths[minMax[0]][0] + " (Length = " + wordLengths[minMax[0]][1] + ")");
        System.out.println("Longest word: " + wordLengths[minMax[1]][0] + " (Length = " + wordLengths[minMax[1]][1] + ")");
        scanner.close();
    }
}