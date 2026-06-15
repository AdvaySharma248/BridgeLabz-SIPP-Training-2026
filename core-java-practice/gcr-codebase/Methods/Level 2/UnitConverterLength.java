import java.util.Scanner;

public class UnitConverterLength {

    public static double convertYardsToFeet(double yards) {
        double yards2feet = 3;
        return yards * yards2feet;
    }

    public static double convertFeetToYards(double feet) {
        double feet2yards = 0.333333;
        return feet * feet2yards;
    }

    public static double convertMetersToInches(double meters) {
        double meters2inches = 39.3701;
        return meters * meters2inches;
    }

    public static double convertInchesToMeters(double inches) {
        double inches2meters = 0.0254;
        return inches * inches2meters;
    }

    public static double convertInchesToCentimeters(double inches) {
        double inches2cm = 2.54;
        return inches * inches2cm;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Length Unit Converter");
        System.out.println("1. Yards to Feet");
        System.out.println("2. Feet to Yards");
        System.out.println("3. Meters to Inches");
        System.out.println("4. Inches to Meters");
        System.out.println("5. Inches to Centimeters");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        double value;
        switch (choice) {
            case 1:
                System.out.print("Enter the value in yards: ");
                value = scanner.nextDouble();
                double feet = convertYardsToFeet(value);
                System.out.println(value + " yards = " + feet + " feet");
                break;
            case 2:
                System.out.print("Enter the value in feet: ");
                value = scanner.nextDouble();
                double yards = convertFeetToYards(value);
                System.out.println(value + " feet = " + yards + " yards");
                break;
            case 3:
                System.out.print("Enter the value in meters: ");
                value = scanner.nextDouble();
                double inches = convertMetersToInches(value);
                System.out.println(value + " meters = " + inches + " inches");
                break;
            case 4:
                System.out.print("Enter the value in inches: ");
                value = scanner.nextDouble();
                double meters = convertInchesToMeters(value);
                System.out.println(value + " inches = " + meters + " meters");
                break;
            case 5:
                System.out.print("Enter the value in inches: ");
                value = scanner.nextDouble();
                double cm = convertInchesToCentimeters(value);
                System.out.println(value + " inches = " + cm + " centimeters");
                break;
            default:
                System.out.println("Invalid choice");
        }

        scanner.close();
    }
}
