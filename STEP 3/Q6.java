public class Q6 {
    public static String[] findCharacterFrequency(String text) {
        char[] chars = text.toCharArray();
        int[] freq = new int[chars.length];
        
        for (int i = 0; i < chars.length; i++) {
            freq[i] = 1;
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[i] != '0' && chars[i] == chars[j]) {
                    freq[i]++;
                    chars[j] = '0';
                }
            }
        }
        
        int count = 0;
        for (char c : chars) {
            if (c != '0') count++;
        }
        
        String[] result = new String[count];
        int index = 0;
        
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != '0') {
                result[index++] = chars[i] + ":" + freq[i];
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        
        String[] frequencies = findCharacterFrequency(input);
        System.out.println("Character frequencies:");
        for (String freq : frequencies) {
            System.out.println(freq);
        }
        
        scanner.close();
    }
}
