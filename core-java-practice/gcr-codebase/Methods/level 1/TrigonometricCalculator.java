import java.util.Scanner;

public class TrigonometricCalculator {

    public static double[] calculateTrigonometricFunctions(double angle) {
        double radians = Math.toRadians(angle);
        double sine = Math.sin(radians);
        double cosine = Math.cos(radians);
        double tangent = Math.tan(radians);
        double[] result = {sine, cosine, tangent};
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the angle in degrees: ");
        double angle = scanner.nextDouble();

        double[] result = calculateTrigonometricFunctions(angle);

        System.out.println("Sine of " + angle + " degrees is " + result[0]);
        System.out.println("Cosine of " + angle + " degrees is " + result[1]);
        System.out.println("Tangent of " + angle + " degrees is " + result[2]);

        scanner.close();
    }
}
