import java.util.Scanner;

public class NumberCheckerSpecialNumbers {

    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int findDigitSum(int number) {
        int sum = 0;
        while (number > 0) {
            sum = sum + number % 10;
            number = number / 10;
        }
        return sum;
    }

    public static boolean isNeonNumber(int number) {
        int square = number * number;
        int digitSum = findDigitSum(square);
        return digitSum == number;
    }

    public static boolean isSpyNumber(int number) {
        int sum = 0;
        int product = 1;
        int temp = number;
        while (temp > 0) {
            int digit = temp % 10;
            sum = sum + digit;
            product = product * digit;
            temp = temp / 10;
        }
        return sum == product;
    }

    public static boolean isAutomorphicNumber(int number) {
        int square = number * number;
        int temp = number;
        while (temp > 0) {
            if (temp % 10 != square % 10) {
                return false;
            }
            temp = temp / 10;
            square = square / 10;
        }
        return true;
    }

    public static boolean isBuzzNumber(int number) {
        if (number % 7 == 0 || number % 10 == 7) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        boolean prime = isPrime(number);
        System.out.println("Prime Number: " + prime);

        boolean neon = isNeonNumber(number);
        System.out.println("Neon Number: " + neon);

        boolean spy = isSpyNumber(number);
        System.out.println("Spy Number: " + spy);

        boolean automorphic = isAutomorphicNumber(number);
        System.out.println("Automorphic Number: " + automorphic);

        boolean buzz = isBuzzNumber(number);
        System.out.println("Buzz Number: " + buzz);

        scanner.close();
    }
}
