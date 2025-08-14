import java.util.Scanner;

public class TextLowerCaseConverter {
    
    public static String convertToLowerCase(String text) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                result.append((char)(ch + 32));
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }
    
    public static boolean compareStrings(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a text: ");
        String input = scanner.nextLine();
        
        // Convert using custom method
        String customLowerCase = convertToLowerCase(input);
        
        // Convert using built-in method
        String builtInLowerCase = input.toLowerCase();
        
        // Compare results
        boolean areEqual = compareStrings(customLowerCase, builtInLowerCase);
        
        // Display results
        System.out.println("\nCustom method result: " + customLowerCase);
        System.out.println("Built-in method result: " + builtInLowerCase);
        System.out.println("Results are equal: " + areEqual);
        
        scanner.close();
    }
}