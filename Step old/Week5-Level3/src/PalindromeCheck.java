import java.util.Scanner;

public class PalindromeCheck {
    
    public static boolean isPalindromeIterative(String text) {
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
    
    public static boolean isPalindromeRecursive(String text, int start, int end) {
        if (start >= end) {
            return true;
        }
        
        if (text.charAt(start) != text.charAt(end)) {
            return false;
        }
        
        return isPalindromeRecursive(text, start + 1, end - 1);
    }
    
    public static String reverseString(String text) {
        StringBuilder reversed = new StringBuilder();
        for (int i = text.length() - 1; i >= 0; i--) {
            reversed.append(text.charAt(i));
        }
        return reversed.toString();
    }
    
    public static boolean isPalindromeUsingArray(String text) {
        char[] original = text.toCharArray();
        char[] reversed = reverseString(text).toCharArray();
        
        for (int i = 0; i < original.length; i++) {
            if (original[i] != reversed[i]) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a string to check for palindrome: ");
        String input = scanner.nextLine();
        
        System.out.println("\nResults using different methods:");
        System.out.println("--------------------------------");
        System.out.println("1. Using Iterative method: " + 
            isPalindromeIterative(input));
        
        System.out.println("2. Using Recursive method: " + 
            isPalindromeRecursive(input, 0, input.length() - 1));
        
        System.out.println("3. Using Array method: " + 
            isPalindromeUsingArray(input));
        
        scanner.close();
    }
}