import java.util.Scanner;

public class UnitConverterDistance {

    public static double convertKmToMiles(double km) {
        double km2miles = 0.621371;
        return km * km2miles;
    }

    public static double convertMilesToKm(double miles) {
        double miles2km = 1.60934;
        return miles * miles2km;
    }

    public static double convertMetersToFeet(double meters) {
        double meters2feet = 3.28084;
        return meters * meters2feet;
    }

    public static double convertFeetToMeters(double feet) {
        double feet2meters = 0.3048;
        return feet * feet2meters;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Distance Unit Converter");
        System.out.println("1. Kilometers to Miles");
        System.out.println("2. Miles to Kilometers");
        System.out.println("3. Meters to Feet");
        System.out.println("4. Feet to Meters");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        double value;
        switch (choice) {
            case 1:
                System.out.print("Enter the value in kilometers: ");
                value = scanner.nextDouble();
                double miles = convertKmToMiles(value);
                System.out.println(value + " km = " + miles + " miles");
                break;
            case 2:
                System.out.print("Enter the value in miles: ");
                value = scanner.nextDouble();
                double km = convertMilesToKm(value);
                System.out.println(value + " miles = " + km + " km");
                break;
            case 3:
                System.out.print("Enter the value in meters: ");
                value = scanner.nextDouble();
                double feet = convertMetersToFeet(value);
                System.out.println(value + " meters = " + feet + " feet");
                break;
            case 4:
                System.out.print("Enter the value in feet: ");
                value = scanner.nextDouble();
                double meters = convertFeetToMeters(value);
                System.out.println(value + " feet = " + meters + " meters");
                break;
            default:
                System.out.println("Invalid choice");
        }

        scanner.close();
    }
}
