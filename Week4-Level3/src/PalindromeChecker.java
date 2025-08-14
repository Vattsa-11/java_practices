import java.util.Arrays;

public class PalindromeChecker {

    public static int[] getDigits(int number) {
        return NumberChecker.getDigits(number);
    }

    public static int[] reverseArray(int[] array) {
        int[] rev = new int[array.length];
        for (int i = 0; i < array.length; i++)
            rev[i] = array[array.length - 1 - i];
        return rev;
    }

    public static boolean isPalindrome(int[] digits) {
        return Arrays.equals(digits, reverseArray(digits));
    }

    public static void main(String[] args) {
        int number = 1221;
        int[] digits = getDigits(number);

        System.out.println("Is Palindrome: " + isPalindrome(digits));
    }
}

