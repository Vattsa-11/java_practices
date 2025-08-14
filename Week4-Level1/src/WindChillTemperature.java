import java.util.Scanner;

public class WindChillTemperature {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Temperature(C): ");
        double temp = input.nextDouble();
        System.out.print("Enter Wind Speed(knots): ");
        double ws = input.nextDouble();
        System.out.printf("WindChill: %.2f", calculateWindChill(temp, ws));
    }
    public static double calculateWindChill(double temperature, double windSpeed) {
        return (35.74 + (0.625 * temperature) + (0.4275 * temperature - 35.75) * Math.pow(windSpeed, 0.16));
    }
}
