import java.util.Scanner;

public class UnitConverterMisc {

    public static double convertFarhenheitToCelsius(double farhenheit) {
        double celsius = (farhenheit - 32) * 5 / 9;
        return celsius;
    }

    public static double convertCelsiusToFarhenheit(double celsius) {
        double farhenheit = (celsius * 9 / 5) + 32;
        return farhenheit;
    }

    public static double convertPoundsToKilograms(double pounds) {
        double pounds2kilograms = 0.453592;
        return pounds * pounds2kilograms;
    }

    public static double convertKilogramsToPounds(double kilograms) {
        double kilograms2pounds = 2.20462;
        return kilograms * kilograms2pounds;
    }

    public static double convertGallonsToLiters(double gallons) {
        double gallons2liters = 3.78541;
        return gallons * gallons2liters;
    }

    public static double convertLitersToGallons(double liters) {
        double liters2gallons = 0.264172;
        return liters * liters2gallons;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Unit Converter");
        System.out.println("1. Fahrenheit to Celsius");
        System.out.println("2. Celsius to Fahrenheit");
        System.out.println("3. Pounds to Kilograms");
        System.out.println("4. Kilograms to Pounds");
        System.out.println("5. Gallons to Liters");
        System.out.println("6. Liters to Gallons");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        double value;
        switch (choice) {
            case 1:
                System.out.print("Enter the value in Fahrenheit: ");
                value = scanner.nextDouble();
                double celsius = convertFarhenheitToCelsius(value);
                System.out.println(value + " Fahrenheit = " + celsius + " Celsius");
                break;
            case 2:
                System.out.print("Enter the value in Celsius: ");
                value = scanner.nextDouble();
                double fahrenheit = convertCelsiusToFarhenheit(value);
                System.out.println(value + " Celsius = " + fahrenheit + " Fahrenheit");
                break;
            case 3:
                System.out.print("Enter the value in pounds: ");
                value = scanner.nextDouble();
                double kilograms = convertPoundsToKilograms(value);
                System.out.println(value + " pounds = " + kilograms + " kilograms");
                break;
            case 4:
                System.out.print("Enter the value in kilograms: ");
                value = scanner.nextDouble();
                double pounds = convertKilogramsToPounds(value);
                System.out.println(value + " kilograms = " + pounds + " pounds");
                break;
            case 5:
                System.out.print("Enter the value in gallons: ");
                value = scanner.nextDouble();
                double liters = convertGallonsToLiters(value);
                System.out.println(value + " gallons = " + liters + " liters");
                break;
            case 6:
                System.out.print("Enter the value in liters: ");
                value = scanner.nextDouble();
                double gallons = convertLitersToGallons(value);
                System.out.println(value + " liters = " + gallons + " gallons");
                break;
            default:
                System.out.println("Invalid choice");
        }

        scanner.close();
    }
}
