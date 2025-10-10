import java.util.Scanner;

public class Factors {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter No: ");
        int num = input.nextInt();
        int[] factors = factor(num);
        int sum = sum(factors), sumOfSquare = sumOfSquare(factors), product = product(factors);

        System.out.print("Factors are: ");
        for (int k : factors) System.out.print(k + " ");
        System.out.print("\n");
        System.out.printf("Sum: %d\nSum of Squares: %d\nProduct: %d", sum, sumOfSquare, product);
    }
    public static int[] factor(int num) {
        int cnt = 0;
        for (int i = 1; i < num; i++) {
            if (num % i == 0) {
                cnt++;
            }
        }
        int[] temp_arr = new int[cnt];
        cnt = 0;
        for (int i = 1; i < num; i++) {
            if (num % i == 0) {
                temp_arr[cnt++] = i;
            }
        }
        return temp_arr;
    }
    public static int sum(int[] fac) {
        int sum = 0;
        for (int i = 0; i < fac.length; i++) {
            sum += fac[i];
        }
        return sum;
    }
    public static int sumOfSquare(int[] fac) {
        int sumofsquare = 0;
        for (int j = 0; j< fac.length ; j++) {
            sumofsquare += (int) Math.pow(fac[j], 2);
        }
        return sumofsquare;
    }
    public static int product(int[] fac) {
        int product = 1;
        for (int j : fac) {
            product *= j;
        }
        return product;
    }
}
