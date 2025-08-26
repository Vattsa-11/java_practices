public class WordCounter {
    public static int countWords(String sentence) {
        int count = 0;
        boolean isWord = false;

        for (int i = 0; i < sentence.length(); i++) {
            if (Character.isLetterOrDigit(sentence.charAt(i))) {
                if (!isWord) {
                    count++;
                    isWord = true;
                }
            } else {
                isWord = false;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String input = "Hello, how are you today?";
        int words = countWords(input);
        System.out.println("Number of words: " + words);
    }
}
