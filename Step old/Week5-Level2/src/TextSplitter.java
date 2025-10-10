import java.util.Scanner;

public class TextSplitter {

    // Method to get length of a string without using the built-in length() method
    public static int customLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (Exception e) {
            // Exception indicates we've reached the end of the string.
        }
        return count;
    }

    // Method to split the text into words without using the built-in split() method
    public static String[] customSplit(String text) {
        // First trim the text to remove leading/trailing spaces
        String trimmed = text.trim();
        // Using customLength to get the string's length
        int len = customLength(trimmed);

        // Count the number of spaces
        int spaceCount = 0;
        for (int i = 0; i < len; i++) {
            if (trimmed.charAt(i) == ' ') {
                spaceCount++;
            }
        }
        // Number of words is one more than the count of spaces
        int wordCount = spaceCount + 1;

        // Create an array to store indexes of spaces
        int[] spaceIndexes = new int[spaceCount];
        int idx = 0;
        for (int i = 0; i < len; i++) {
            if (trimmed.charAt(i) == ' ') {
                spaceIndexes[idx++] = i;
            }
        }

        // Create an array to store the words
        String[] words = new String[wordCount];
        int start = 0;
        int wordIndex = 0;
        // Extract words by using the space indexes
        for (int i = 0; i < spaceCount; i++) {
            int end = spaceIndexes[i];
            words[wordIndex++] = trimmed.substring(start, end);
            start = end + 1;
        }
        // Extract the last word (from the last space to the end)
        words[wordIndex] = trimmed.substring(start, len);

        return words;
    }

    // Method to compare two String arrays
    public static boolean compareArrays(String[] arr1, String[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].equals(arr2[i])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the complete text: ");
        String input = scanner.nextLine();

        // Use customSplit() to split the text
        String[] customWords = customSplit(input);
        // Use the built-in split() method to split the text (using one or more whitespace characters)
        String[] builtInWords = input.trim().split("\\s+");

        // Display the results
        System.out.println("\nWords using custom method:");
        for (String word : customWords) {
            System.out.print(word + " | ");
        }

        System.out.println("\n\nWords using built-in split() method:");
        for (String word : builtInWords) {
            System.out.print(word + " | ");
        }

        // Compare the two arrays
        boolean areEqual = compareArrays(customWords, builtInWords);
        System.out.println("\n\nThe two methods produce the same result: " + areEqual);

        scanner.close();
    }
}