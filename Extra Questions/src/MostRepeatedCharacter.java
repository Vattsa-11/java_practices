public class MostRepeatedCharacter {
    public static char mostRepeated(String str) {
        int[] freq = new int[256]; // ASCII characters
        for (char c : str.toCharArray()) {
            freq[c]++;
        }

        int maxFreq = 0;
        char mostRepeated = '\0';

        for (char c : str.toCharArray()) {
            if (freq[c] > maxFreq) {
                maxFreq = freq[c];
                mostRepeated = c;
            }
        }
        return mostRepeated;
    }

    public static void main(String[] args) {
        String input = "successes";
        char result = mostRepeated(input);
        System.out.println("Most repeated character: " + result);
    }
}
