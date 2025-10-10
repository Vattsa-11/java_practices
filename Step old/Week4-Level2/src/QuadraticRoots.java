import java.util.Scanner;

public class QuadraticRoots{
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter value for a: ");
        int value_a = input.nextInt();
        System.out.print("Enter value for b: ");
        int value_b = input.nextInt();
        System.out.print("Enter value for c: ");
        int value_c = input.nextInt();
        double[] total_roots = root(value_a, value_b, value_c);
        if (total_roots != null){
            System.out.printf("Roots are %.2f, %.2f",total_roots[0], total_roots[1]);
        }
    }
    public static double[] root(int a, int b, int c){
        int delta = b*b + 4*a*c;
        if (delta > 0){
            double v = -b - Math.pow(delta, 0.5);
            return new double[]{(-b + v), (-b -v)};
        } else if ( delta == 0) return new double[]{((double) -b /(2*a)), 0};
        else return null;
    }
}
