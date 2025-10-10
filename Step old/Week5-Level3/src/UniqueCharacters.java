import java.util.Scanner;

public class UniqueCharacters {
    
    public static int findLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            return count;
        }
    }
    
    public static char[] findUniqueChars(String text) {
        int length = findLength(text);
        char[] tempArray = new char[length];
        int uniqueCount = 0;
        
        for (int i = 0; i < length; i++) {
            boolean isUnique = true;
            
            for (int j = 0; j < uniqueCount; j++) {
                if (text.charAt(i) == tempArray[j]) {
                    isUnique = false;
                    break;
                }
            }
            
            if (isUnique) {
                tempArray[uniqueCount] = text.charAt(i);
                uniqueCount++;
            }
        }
        
        char[] uniqueChars = new char[uniqueCount];
        for (int i = 0; i < uniqueCount; i++) {
            uniqueChars[i] = tempArray[i];
        }
        
        return uniqueChars;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        
        char[] uniqueChars = findUniqueChars(input);
        
        System.out.print("Unique characters are: ");
        for (char c : uniqueChars) {
            System.out.print(c + " ");
        }
        
        scanner.close();
    }
}