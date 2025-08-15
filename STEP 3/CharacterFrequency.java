import java.util.Scanner;

public class CharacterFrequency {
    
    public static int[][] findCharacterFrequency(String text) {
        
        int[] frequency = new int[256]; 
        
        
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            frequency[ch]++; 
        }
        
        
        int uniqueCount = 0;
        for (int i = 0; i < 256; i++) {
            if (frequency[i] > 0) {
                uniqueCount++;
            }
        }
        
        
        int[][] result = new int[uniqueCount][2];
        int index = 0;
        
        
        for (int i = 0; i < 256; i++) {
            if (frequency[i] > 0) {
                result[index][0] = i;           
                result[index][1] = frequency[i]; 
                index++;
            }
        }
        
        return result;
    }
    
    
    public static void displayFrequencies(int[][] frequencies) {
        System.out.printf("%s\t\t%s", "Character", "Frequency");
        System.out.println("\n");
        
        for (int i = 0; i < frequencies.length; i++) {
            char character = (char) frequencies[i][0];
            int freq = frequencies[i][1];
            
            
            String charDisplay;
            if (character == ' ') {
                charDisplay = "Space";
            } else if (character == '\t') {
                charDisplay = "Tab";
            } else if (character == '\n') {
                charDisplay = "Newline";
            } else {
                charDisplay = String.valueOf(character);
            }
            
            System.out.printf("%s\t\t\t%d\n", charDisplay, freq);
        }
    }
    
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String inputText = scanner.nextLine();
        
        if (inputText.isEmpty()) {
            System.out.println("Error: Empty string entered!");
            scanner.close();
            return;
        }
        
        int[][] frequencies = findCharacterFrequency(inputText);
        
        System.out.println("\nInput String: \"" + inputText + "\"");
        System.out.println("Length: " + inputText.length() + " characters");
        displayFrequencies(frequencies);
        
        scanner.close();
    }
}
