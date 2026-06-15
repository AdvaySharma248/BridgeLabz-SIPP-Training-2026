import java.util.Scanner;

public class AthleteTriangularPark {

    public static int calculateRounds(double side1, double side2, double side3, double distance) {
        double perimeter = side1 + side2 + side3;
        int rounds = (int) Math.ceil(distance / perimeter);
        return rounds;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double distanceInMeters = 5000;

        System.out.print("Enter the length of side 1 (in meters): ");
        double side1 = scanner.nextDouble();

        System.out.print("Enter the length of side 2 (in meters): ");
        double side2 = scanner.nextDouble();

        System.out.print("Enter the length of side 3 (in meters): ");
        double side3 = scanner.nextDouble();

        int rounds = calculateRounds(side1, side2, side3, distanceInMeters);

        System.out.println("The athlete must complete " + rounds + " rounds to finish a 5 km run");

        scanner.close();
    }
}
