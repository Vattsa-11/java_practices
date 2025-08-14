import java.util.Scanner;

public class StringLengthDemo {

    public static int customLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (Exception e) {
            // Exception indicates we've reached the end of the string.
        }
        return count;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String input = scanner.next();
        
        int customLen = customLength(input);
        int builtInLen = input.length();
        
        System.out.println("Custom method length: " + customLen);
        System.out.println("Built-in method length: " + builtInLen);
        
        scanner.close();
    }
}