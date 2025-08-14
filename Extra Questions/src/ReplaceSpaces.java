public class ReplaceSpaces {
    public static String replaceSpaces(String str) {
        StringBuilder result = new StringBuilder();

        for (char c : str.toCharArray()) {
            if (c == ' ') {
                result.append('_');
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String input = "Java is fun";
        String output = replaceSpaces(input);
        System.out.println("After replacing spaces: " + output);
    }
}
