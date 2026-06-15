import java.util.Scanner;

public class EuclideanDistanceCalculator {

    public static double findEuclideanDistance(double x1, double y1, double x2, double y2) {
        double distance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        return distance;
    }

    public static double[] findLineEquation(double x1, double y1, double x2, double y2) {
        double slope = (y2 - y1) / (x2 - x1);
        double yIntercept = y1 - slope * x1;
        double[] result = {slope, yIntercept};
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter x1: ");
        double x1 = scanner.nextDouble();
        System.out.print("Enter y1: ");
        double y1 = scanner.nextDouble();

        System.out.print("Enter x2: ");
        double x2 = scanner.nextDouble();
        System.out.print("Enter y2: ");
        double y2 = scanner.nextDouble();

        double distance = findEuclideanDistance(x1, y1, x2, y2);
        System.out.println("The Euclidean distance between (" + x1 + "," + y1 + ") and (" + x2 + "," + y2 + ") is " + String.format("%.4f", distance));

        double[] lineEquation = findLineEquation(x1, y1, x2, y2);
        double slope = lineEquation[0];
        double yIntercept = lineEquation[1];

        System.out.println("The equation of the line is:");
        System.out.println("Slope (m): " + String.format("%.4f", slope));
        System.out.println("Y-intercept (b): " + String.format("%.4f", yIntercept));
        System.out.println("Equation: y = " + String.format("%.4f", slope) + "x + " + String.format("%.4f", yIntercept));

        scanner.close();
    }
}
