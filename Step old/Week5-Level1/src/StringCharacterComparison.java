import java.util.Scanner;

public class StringCharacterComparison {
    
    public static char[] convertToCharArray(String str) {
        char[] result = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            result[i] = str.charAt(i);
        }
        return result;
    }
    
    public static boolean compareCharArrays(char[] arr1, char[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String input = scanner.next();
        
        char[] customArray = convertToCharArray(input);
        char[] builtInArray = input.toCharArray();
        
        boolean areEqual = compareCharArrays(customArray, builtInArray);
        
        System.out.println("\nCustom method result:");
        for (char c : customArray) {
            System.out.print(c + " ");
        }
        
        System.out.println("\n\nBuilt-in method result:");
        for (char c : builtInArray) {
            System.out.print(c + " ");
        }
        
        System.out.println("\n\nArrays are equal: " + areEqual);
        
        scanner.close();
    }
}