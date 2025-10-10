public class PrimeBuzzNeonChecker {

    public static boolean isPrime(int number) {
        if (number < 2) return false;
        for (int i = 2; i <= Math.sqrt(number); i++)
            if (number % i == 0) return false;
        return true;
    }

    public static boolean isNeon(int number) {
        int square = number * number;
        int sum = 0;
        while (square > 0) {
            sum += square % 10;
            square /= 10;
        }
        return sum == number;
    }

    public static boolean isSpy(int number) {
        int sum = 0, prod = 1;
        while (number > 0) {
            int d = number % 10;
            sum += d;
            prod *= d;
            number /= 10;
        }
        return sum == prod;
    }

    public static boolean isAutomorphic(int number) {
        return String.valueOf(number * number).endsWith(String.valueOf(number));
    }

    public static boolean isBuzz(int number) {
        return number % 7 == 0 || number % 10 == 7;
    }

    public static void main(String[] args) {
        int number = 7;
        System.out.println("Prime: " + isPrime(number));
        System.out.println("Neon: " + isNeon(number));
        System.out.println("Spy: " + isSpy(number));
        System.out.println("Automorphic: " + isAutomorphic(number));
        System.out.println("Buzz: " + isBuzz(number));
    }
}
