import java.util.Scanner;

public class CharFrequencyNestedLoops {
    
    public static String[] findFrequency(String text) {
        char[] chars = text.toCharArray();
        int[] frequency = new int[chars.length];
        
        for (int i = 0; i < chars.length; i++) {
            frequency[i] = 1;
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[i] != '0' && chars[i] == chars[j]) {
                    frequency[i]++;
                    chars[j] = '0';
                }
            }
        }
        
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != '0') {
                count++;
            }
        }
        
        String[] result = new String[count];
        int index = 0;
        
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != '0') {
                result[index] = chars[i] + ":" + frequency[i];
                index++;
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        
        String[] charFrequency = findFrequency(input);
        
        System.out.println("\nCharacter frequencies:");
        System.out.println("Character : Frequency");
        System.out.println("-------------------");
        
        for (String freq : charFrequency) {
            String[] parts = freq.split(":");
            System.out.println("    " + parts[0] + "    :    " + parts[1]);
        }
        
        scanner.close();
    }
}