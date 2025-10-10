import java.util.Arrays;
import java.util.Scanner;

public class TextProcessor {
    
    public static String cleanInput(String input) {
        if (input == null) return "";
        // Remove extra spaces and trim
        return input.trim().replaceAll("\\s+", " ");
    }
    
    public static void analyzeText(String text) {
        // Count words
        String[] words = text.split("\\s+");
        int wordCount = words.length;
        
        // Count characters (excluding spaces)
        int charCount = text.replace(" ", "").length();
        
        // Find longest word
        String longestWord = "";
        for (String word : words) {
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }
        
        // Display statistics
        System.out.println("\nText Analysis:");
        System.out.println("Words: " + wordCount);
        System.out.println("Characters (no spaces): " + charCount);
        System.out.println("Longest word: " + longestWord);
    }
    
    public static String[] getWordsSorted(String text) {
        // Split into words and sort
        String[] words = text.split("\\s+");
        Arrays.sort(words);
        return words;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== TEXT PROCESSOR ===");
        System.out.println("Enter your text:");
        String input = scanner.nextLine();
        
        String cleanedText = cleanInput(input);
        System.out.println("\nCleaned text: " + cleanedText);
        
        analyzeText(cleanedText);
        
        System.out.println("\nWords in alphabetical order:");
        String[] sortedWords = getWordsSorted(cleanedText);
        for (String word : sortedWords) {
            System.out.println(word);
        }
        
        System.out.println("\nEnter a word to search (or 'exit'):");
        while (true) {
            String searchWord = scanner.nextLine();
            if (searchWord.equals("exit")) break;
            
            int count = 0;
            for (String word : sortedWords) {
                if (word.equalsIgnoreCase(searchWord)) count++;
            }
            System.out.println("Found '" + searchWord + "' " + count + " times");
        }
        
        scanner.close();
    }
}