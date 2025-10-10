public class NullPointerExceptionDemo {
    
    // Method to generate NullPointerException
    public static void generateNullPointerException() {
        String text = null;
        System.out.println("Trying to get length of null string:");
        System.out.println("Length of text: " + (text != null ? text.length() : 0));
    }
    
    // Method to handle NullPointerException
    public static void handleNullPointerException() {
        String text = null;
        try {
            System.out.println("Trying to get length of null string (with exception handling):");
            System.out.println("Length of text: " + text.length());
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException!");
            System.out.println("Error message: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        System.out.println("1. Demonstrating NullPointerException without handling:");
        try {
            generateNullPointerException();
        } catch (Exception e) {
            System.out.println("Main caught the exception: " + e.toString());
        }
        
        System.out.println("\n2. Demonstrating NullPointerException with handling:");
        handleNullPointerException();
    }
}