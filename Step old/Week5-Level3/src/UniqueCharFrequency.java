import java.util.Scanner;

public class UniqueCharFrequency {
    
    public static char[] findUniqueChars(String text) {
        char[] tempArray = new char[text.length()];
        int uniqueCount = 0;
        
        for (int i = 0; i < text.length(); i++) {
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
    
    public static String[][] findFrequency(String text) {
        int[] frequency = new int[256];
        
        for (int i = 0; i < text.length(); i++) {
            frequency[text.charAt(i)]++;
        }
        
        char[] uniqueChars = findUniqueChars(text);
        String[][] result = new String[uniqueChars.length][2];
        
        for (int i = 0; i < uniqueChars.length; i++) {
            result[i][0] = String.valueOf(uniqueChars[i]);
            result[i][1] = String.valueOf(frequency[uniqueChars[i]]);
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        
        String[][] charFrequency = findFrequency(input);
        
        System.out.println("\nCharacter frequencies:");
        System.out.println("Character\tFrequency");
        System.out.println("---------\t---------");
        
        for (String[] freq : charFrequency) {
            System.out.println(freq[0] + "\t\t" + freq[1]);
        }
        
        scanner.close();
    }
}