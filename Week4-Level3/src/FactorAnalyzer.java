public class FactorAnalyzer {

    public static int[] getFactors(int number) {
        int count = 0;
        for (int i = 1; i <= number; i++)
            if (number % i == 0) count++;

        int[] factors = new int[count];
        int index = 0;
        for (int i = 1; i <= number; i++)
            if (number % i == 0) factors[index++] = i;

        return factors;
    }

    public static int sum(int[] arr) {
        int s = 0;
        for (int a : arr) s += a;
        return s;
    }

    public static int product(int[] arr) {
        int p = 1;
        for (int a : arr) p *= a;
        return p;
    }

    public static int productOfCubes(int[] arr) {
        int p = 1;
        for (int a : arr) p *= Math.pow(a, 3);
        return p;
    }

    public static boolean isPerfect(int number) {
        int sum = 0;
        for (int i = 1; i < number; i++)
            if (number % i == 0) sum += i;
        return sum == number;
    }

    public static boolean isAbundant(int number) {
        int sum = 0;
        for (int i = 1; i < number; i++)
            if (number % i == 0) sum += i;
        return sum > number;
    }

    public static boolean isDeficient(int number) {
        int sum = 0;
        for (int i = 1; i < number; i++)
            if (number % i == 0) sum += i;
        return sum < number;
    }

    public static boolean isStrong(int number) {
        int temp = number, sum = 0;
        while (temp > 0) {
            int d = temp % 10;
            sum += factorial(d);
            temp /= 10;
        }
        return sum == number;
    }

    public static int factorial(int n) {
        int f = 1;
        for (int i = 1; i <= n; i++) f *= i;
        return f;
    }

    public static void main(String[] args) {
        int num = 28;
        System.out.println("Perfect: " + isPerfect(num));
        System.out.println("Abundant: " + isAbundant(num));
        System.out.println("Deficient: " + isDeficient(num));
        System.out.println("Strong: " + isStrong(num));
    }
}
