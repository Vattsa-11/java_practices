import java.util.Scanner;
public class VowelConsonantType {
    public static String checkChar(char ch) {
        char lower = (ch >= 'A' && ch <= 'Z') ? (char)(ch + 32) : ch;
        if(lower >= 'a' && lower <= 'z') {
            if(lower == 'a' || lower == 'e' || lower == 'i' || lower == 'o' || lower == 'u')
                return "Vowel";
            else
                return "Consonant";
        }
        return "Not a Letter";
    }
    public static String[][] analyzeString(String text) {
        int n = text.length();
        String[][] result = new String[n][2];
        for (int i = 0; i < n; i++) {
            char ch = text.charAt(i);
            result[i][0] = String.valueOf(ch);
            result[i][1] = checkChar(ch);
        }
        return result;
    }
    public static void print2DArray(String[][] arr) {
        System.out.println("Character\tType");
        System.out.println("------------------------");
        for (String[] row : arr) {
            System.out.println(row[0] + "\t\t" + row[1]);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        String[][] analysis = analyzeString(input);
        print2DArray(analysis);
        scanner.close();
    }
}