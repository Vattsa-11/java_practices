public class StringTrimmer {
    public static int[] findTrimIndices(String str) {
        int start = 0;
        int end = str.length() - 1;
        while (start < str.length() && str.charAt(start) == ' ') {
            start++;
        }
        while (end >= start && str.charAt(end) == ' ') {
            end--;
        }
        return new int[]{start, end};
    }
    public static String customSubstring(String str, int start, int end) {
        StringBuilder result = new StringBuilder();
        for (int i = start; i <= end; i++) {
            result.append(str.charAt(i));
        }
        return result.toString();
    }
    public static boolean compareStrings(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String text = "   Hello World   ";
        System.out.println("Original string: '" + text + "'");
        int[] indices = findTrimIndices(text);
        String customTrimmed = customSubstring(text, indices[0], indices[1]);
        System.out.println("Custom trimmed: '" + customTrimmed + "'");        
        String builtInTrimmed = text.trim();
        System.out.println("Built-in trimmed: '" + builtInTrimmed + "'");
        boolean areEqual = compareStrings(customTrimmed, builtInTrimmed);
        System.out.println("Custom trim matches built-in trim: " + areEqual);
    }
}