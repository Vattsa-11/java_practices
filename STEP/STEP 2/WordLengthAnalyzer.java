import java.util.Scanner;
import java.util.ArrayList;
public class WordLengthAnalyzer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a text: ");
        String text = scanner.nextLine();
        
        if (text == null || text.trim().isEmpty()) {
            System.out.println("Error: Please enter valid text");
            scanner.close();
            return;
        }
        
        String[] words = splitIntoWords(text);
        System.out.println("\nWord\t\tLength");
        System.out.println("--------------------");
        for (String word : words) {
            // Adjust tab spacing based on word length
            String tabs = word.length() < 8 ? "\t\t" : "\t";
            System.out.println(word + tabs + getWordLength(word));
        }
        scanner.close();
    }
    
    public static String[] splitIntoWords(String text) {
        ArrayList<String> wordsList = new ArrayList<>();
        StringBuilder word = new StringBuilder();
        
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                if (word.length() > 0) {
                    wordsList.add(word.toString());
                    word.setLength(0);
                }
            } else {
                word.append(text.charAt(i));
            }
        }
        if (word.length() > 0) {
            wordsList.add(word.toString());
        }
        
        return wordsList.toArray(new String[0]);
    }
    
    public static int getWordLength(String word) {
        int length = 0;
        for (int i = 0; i < word.length(); i++) {
            length++;
        }
        return length;
    }
}