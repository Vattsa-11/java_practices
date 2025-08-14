public class NumberChecker {

    public static int countDigits(int number) {
        return String.valueOf(number).length();
    }

    public static int[] getDigits(int number) {
        int[] digits = new int[countDigits(number)];
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] = number % 10;
            number /= 10;
        }
        return digits;
    }

    public static boolean isDuckNumber(int[] digits) {
        for (int i = 1; i < digits.length; i++) if (digits[i] == 0) return true;
        return false;
    }

    public static boolean isArmstrong(int[] digits, int number) {
        int sum = 0;
        for (int d : digits) sum += (int) Math.pow(d, digits.length);
        return sum == number;
    }

    public static int[] findTwoLargest(int[] digits) {
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;
        for (int d : digits) {
            if (d > max1) {
                max2 = max1;
                max1 = d;
            } else if (d > max2 && d != max1) max2 = d;
        }
        return new int[]{max1, max2};
    }

    public static int[] findTwoSmallest(int[] digits) {
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        for (int d : digits) {
            if (d < min1) {
                min2 = min1;
                min1 = d;
            } else if (d < min2 && d != min1) min2 = d;
        }
        return new int[]{min1, min2};
    }

    public static void main(String[] args) {
        int number = 153;
        int[] digits = getDigits(number);

        System.out.println("Duck: " + isDuckNumber(digits));
        System.out.println("Armstrong: " + isArmstrong(digits, number));

        int[] max = findTwoLargest(digits);
        int[] min = findTwoSmallest(digits);
        System.out.println("Max: " + max[0] + ", 2nd Max: " + max[1]);
        System.out.println("Min: " + min[0] + ", 2nd Min: " + min[1]);
    }
}

