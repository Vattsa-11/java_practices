import java.util.Scanner;
public class PalindromeCheck {
    
    
    public static boolean Iterative(String text) {
        int start = 0;
        int end = text.length() - 1;
        
        while (start < end) {
            if (text.charAt(start) != text.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    
    public static boolean Recursive(String text, int start, int end) {
        if (start >= end) {
            return true;
        }
        if (text.charAt(start) != text.charAt(end)) {
            return false;
        }
        return Recursive(text, start + 1, end - 1);
    }

    
    public static boolean PalindromeArray(String text) {
        char[] original = text.toCharArray();
        char[] reverse = new char[original.length];
        
        
        for (int i = 0; i < original.length; i++) {
            reverse[i] = text.charAt(text.length() - 1 - i);
        }
        
        
        for (int i = 0; i < original.length; i++) {
            if (original[i] != reverse[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string to check if it's a palindrome: ");
        String text = input.nextLine();
        input.close();
    
        System.out.println("\nTesting: " + text);
        System.out.println("Logic 1 (Iterative): " + Iterative(text));
        System.out.println("Logic 2 (Recursive): " + Recursive(text, 0, text.length() - 1));
        System.out.println("Logic 3 (Array): " + PalindromeArray(text));
    
    }
}