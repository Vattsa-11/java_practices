import java.util.Scanner;

public class NonRepeatingChar {
    
    public static char findFirstNonRepeating(String str) {
        int[] frequency = new int[256];
        
        for (int i = 0; i < str.length(); i++) {
            frequency[str.charAt(i)]++;
        }
        
        for (int i = 0; i < str.length(); i++) {
            if (frequency[str.charAt(i)] == 1) {
                return str.charAt(i);
            }
        }
        
        return '\0';
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        
        char result = findFirstNonRepeating(input);
        
        if (result != '\0') {
            System.out.println("First non-repeating character is: " + result);
        } else {
            System.out.println("No non-repeating character found.");
        }
        
        scanner.close();
    }
}