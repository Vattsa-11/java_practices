public class FibonacciSeries {
    public static void main(String[] args) {
        int n = 10; // How many numbers you want in the series
        int a = 0, b = 1;

        System.out.println("Fibonacci Series up to " + n + " numbers:");
        for (int i = 0; i < n; i++) {
            System.out.print(a + " ");
            int next = a + b;
            a = b;
            b = next;
        }
    }
}
