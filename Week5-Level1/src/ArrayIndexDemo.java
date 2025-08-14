import java.util.Scanner;

public class ArrayIndexDemo {
    
    public static void generateArrayIndexException(String[] names) {
        System.out.println("Trying to access index beyond array length:");
        // Attempting to access index beyond array length
        System.out.println("Name at index " + names.length + ": " + names[names.length]);
    }
    
    public static void handleArrayIndexException(String[] names) {
        try {
            System.out.println("Trying to access index beyond array length (with exception handling):");
            System.out.println("Name at index " + names.length + ": " + names[names.length]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught ArrayIndexOutOfBoundsException!");
            System.out.println("Error message: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Caught other RuntimeException!");
            System.out.println("Error message: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of names: ");
        int size = scanner.nextInt();
        scanner.nextLine(); // consume newline
        
        String[] names = new String[size];
        
        // Input names
        for (int i = 0; i < size; i++) {
            System.out.print("Enter name " + (i + 1) + ": ");
            names[i] = scanner.nextLine();
        }
        
        System.out.println("\n1. Demonstrating ArrayIndexOutOfBoundsException without handling:");
        try {
            generateArrayIndexException(names);
        } catch (Exception e) {
            System.out.println("Main caught the exception: " + e.toString());
        }
        
        System.out.println("\n2. Demonstrating ArrayIndexOutOfBoundsException with handling:");
        handleArrayIndexException(names);
        
        scanner.close();
    }
}