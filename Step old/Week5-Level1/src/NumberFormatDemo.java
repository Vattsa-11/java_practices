import java.util.Scanner;

public class NumberFormatDemo {
    
    public static void generateNumberFormatException(String text) {
        System.out.println("Trying to parse non-numeric string to integer:");
        int number = Integer.parseInt(text);
        System.out.println("Parsed number: " + number);
    }
    
    public static void handleNumberFormatException(String text) {
        try {
            System.out.println("Trying to parse non-numeric string to integer (with exception handling):");
            int number = Integer.parseInt(text);
            System.out.println("Parsed number: " + number);
        } catch (NumberFormatException e) {
            System.out.println("Caught NumberFormatException!");
            System.out.println("Error message: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Caught other RuntimeException!");
            System.out.println("Error message: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a non-numeric string: ");
        String input = scanner.nextLine();
        
        System.out.println("\n1. Demonstrating NumberFormatException without handling:");
        try {
            generateNumberFormatException(input);
        } catch (Exception e) {
            System.out.println("Main caught the exception: " + e.toString());
        }
        
        System.out.println("\n2. Demonstrating NumberFormatException with handling:");
        handleNumberFormatException(input);
        
        scanner.close();
    }
}