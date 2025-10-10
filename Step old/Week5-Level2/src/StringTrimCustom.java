import java.util.Scanner;
public class StringTrimCustom {
    public static int[] customTrimIndices(String text) {
        int len = 0;
        try { while (true) { text.charAt(len); len++; } } catch(Exception e) {}
        int start = 0;
        while(start < len && text.charAt(start) == ' ') { start++; }
        int end = len - 1;
        while(end >= 0 && text.charAt(end) == ' ') { end--; }
        return new int[]{start, end};
    }
    public static String customSubstring(String text, int start, int end) {
        String result = "";
        for (int i = start; i <= end; i++) { result += text.charAt(i); }
        return result;
    }
    public static boolean compareStrings(String str1, String str2) {
        int len1 = 0, len2 = 0;
        try { while(true) { str1.charAt(len1); len1++; } } catch(Exception e) {}
        try { while(true) { str2.charAt(len2); len2++; } } catch(Exception e) {}
        if(len1 != len2) return false;
        for (int i = 0; i < len1; i++) { if(str1.charAt(i) != str2.charAt(i)) return false; }
        return true;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string with spaces: ");
        String input = scanner.nextLine();
        int[] indices = customTrimIndices(input);
        String trimmedCustom = (indices[0] <= indices[1]) ? customSubstring(input, indices[0], indices[1]) : "";
        String trimmedBuiltIn = input.trim();
        boolean compareResult = compareStrings(trimmedCustom, trimmedBuiltIn);
        System.out.println("Custom Trim Result: '" + trimmedCustom + "'");
        System.out.println("Built-in Trim Result: '" + trimmedBuiltIn + "'");
        System.out.println("Results are equal: " + compareResult);
        scanner.close();
    }
}