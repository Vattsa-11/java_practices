import java.util.Scanner;

public class IllegalArgumentDemo {
    
    public static void generateIllegalArgumentException(String text) {
        System.out.println("Trying to get substring with invalid indices:");
        // Attempting to create substring with start index > end index
        String result = text.substring(5, 2);
        System.out.println("Substring result: " + result);
    }
    
    public static void handleIllegalArgumentException(String text) {
        try {
            System.out.println("Trying to get substring with invalid indices (with exception handling):");
            String result = text.substring(5, 2);
            System.out.println("Substring result: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught IllegalArgumentException!");
            System.out.println("Error message: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Caught other RuntimeException!");
            System.out.println("Error message: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        
        System.out.println("\n1. Demonstrating IllegalArgumentException without handling:");
        try {
            generateIllegalArgumentException(input);
        } catch (Exception e) {
            System.out.println("Main caught the exception: " + e.toString());
        }
        
        System.out.println("\n2. Demonstrating IllegalArgumentException with handling:");
        handleIllegalArgumentException(input);
        
        scanner.close();
    }
}