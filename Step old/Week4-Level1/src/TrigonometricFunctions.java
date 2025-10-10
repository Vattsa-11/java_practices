import java.util.Scanner;

public class TrigonometricFunctions {
    public static double[] calculateTrigonometricFunctions(double angle) {
        double radians = Math.toRadians(angle);
        return new double[] {Math.sin(radians), Math.cos(radians), Math.tan(radians)};
    }
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Angle: ");
        double ang = input.nextDouble();
        double[] functions = calculateTrigonometricFunctions(ang);
        System.out.printf("Sin: %.2f\nCos: %.2f\nTan: %.2f", functions[0], functions[1], functions[2]);
    }

}
