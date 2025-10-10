
import java.util.Scanner;

public class StringIndexDemo {
    
    public static void generateStringIndexException(String text) {
        System.out.println("Trying to access index beyond string length:");
        // Attempting to access index beyond string length
        char character = text.charAt(text.length() + 1);
        System.out.println("Character at index " + (text.length() + 1) + ": " + character);
    }
    
    public static void handleStringIndexException(String text) {
        try {
            System.out.println("Trying to access index beyond string length (with exception handling):");
            char character = text.charAt(text.length() + 1);
            System.out.println("Character at index " + (text.length() + 1) + ": " + character);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Caught StringIndexOutOfBoundsException!");
            System.out.println("Error message: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        
        System.out.println("\n1. Demonstrating StringIndexOutOfBoundsException without handling:");
        try {
            generateStringIndexException(input);
        } catch (Exception e) {
            System.out.println("Main caught the exception: " + e.toString());
        }
        
        System.out.println("\n2. Demonstrating StringIndexOutOfBoundsException with handling:");
        handleStringIndexException(input);
        
        scanner.close();
    }
}