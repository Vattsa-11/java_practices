import java.util.Scanner;
import java.util.ArrayList;

public class StringAnalyzer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a text: ");
        String text = scanner.nextLine();
        
        String[] words = splitIntoWords(text);
        String[][] wordLengths = getWordLengths(words);
        String[] result = findExtremes(wordLengths);
        
        System.out.println("\nResults:");
        System.out.println("Shortest word: " + result[0]);
        System.out.println("Longest word: " + result[1]);
        scanner.close();
    }
    
    public static String[] splitIntoWords(String text) {
        ArrayList<String> words = new ArrayList<>();
        StringBuilder word = new StringBuilder();
        
        for (int i = 0; i < customLength(text); i++) {
            if (text.charAt(i) != ' ') {
                word.append(text.charAt(i));
            } else if (word.length() > 0) {
                words.add(word.toString());
                word.setLength(0);
            }
        }
        if (word.length() > 0) {
            words.add(word.toString());
        }
        return words.toArray(new String[0]);
    }
    
    public static int customLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (IndexOutOfBoundsException e) {
            return count;
        }
    }
    
    public static String[][] getWordLengths(String[] words) {
        String[][] wordLengths = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            wordLengths[i][0] = words[i];
            wordLengths[i][1] = String.valueOf(customLength(words[i]));
        }
        return wordLengths;
    }
    
    public static String[] findExtremes(String[][] wordLengths) {
        if (wordLengths.length == 0) return new String[]{"", ""};
        
        String shortest = wordLengths[0][0];
        String longest = wordLengths[0][0];
        int shortestLen = Integer.parseInt(wordLengths[0][1]);
        int longestLen = Integer.parseInt(wordLengths[0][1]);
        
        for (String[] word : wordLengths) {
            int currentLen = Integer.parseInt(word[1]);
            if (currentLen < shortestLen) {
                shortest = word[0];
                shortestLen = currentLen;
            }
            if (currentLen > longestLen) {
                longest = word[0];
                longestLen = currentLen;
            }
        }
        return new String[]{shortest, longest};
    }
}