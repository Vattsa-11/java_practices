import java.util.Scanner;

public class SimpleInterest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Principle Amount: ");
        float p = input.nextFloat();
        System.out.print("Enter Rate of Interest: ");
        float r = input.nextFloat();
        System.out.print("Enter Time Period: ");
        float t = input.nextFloat();
        simpleInterest(p, r, t);
    }
    public static void simpleInterest(float principle, float rate, float time) {
        float si = (principle * rate * time) / 100;
        System.out.printf("The Simple Interest is %.2f for Principle %.2f, Rate of Interest %.2f and Time %.2f", si, principle, rate, time);
    }
}
