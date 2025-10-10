import java.util.Scanner;

public class CharacterFrequency {
    
    public static String[][] findFrequency(String text) {
        int[] frequency = new int[256];
        
        for (int i = 0; i < text.length(); i++) {
            frequency[text.charAt(i)]++;
        }
        
        int charCount = 0;
        for (int i = 0; i < 256; i++) {
            if (frequency[i] > 0) {
                charCount++;
            }
        }
        
        String[][] result = new String[charCount][2];
        int index = 0;
        
        for (int i = 0; i < 256; i++) {
            if (frequency[i] > 0) {
                result[index][0] = String.valueOf((char)i);
                result[index][1] = String.valueOf(frequency[i]);
                index++;
            }
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