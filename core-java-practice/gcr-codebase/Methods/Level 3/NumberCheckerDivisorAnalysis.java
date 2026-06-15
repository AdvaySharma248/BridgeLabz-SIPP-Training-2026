import java.util.Scanner;

public class NumberCheckerDivisorAnalysis {

    public static int findSumOfProperDivisors(int number) {
        int sum = 0;
        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                sum = sum + i;
            }
        }
        return sum;
    }

    public static boolean isPerfectNumber(int number) {
        int sum = findSumOfProperDivisors(number);
        return sum == number;
    }

    public static boolean isAbundantNumber(int number) {
        int sum = findSumOfProperDivisors(number);
        return sum > number;
    }

    public static boolean isDeficientNumber(int number) {
        int sum = findSumOfProperDivisors(number);
        return sum < number;
    }

    public static int findFactorial(int number) {
        int factorial = 1;
        for (int i = 1; i <= number; i++) {
            factorial = factorial * i;
        }
        return factorial;
    }

    public static boolean isStrongNumber(int number) {
        int sum = 0;
        int temp = number;
        while (temp > 0) {
            int digit = temp % 10;
            sum = sum + findFactorial(digit);
            temp = temp / 10;
        }
        return sum == number;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        int sumOfDivisors = findSumOfProperDivisors(number);
        System.out.println("Sum of proper divisors: " + sumOfDivisors);

        boolean perfect = isPerfectNumber(number);
        System.out.println("Perfect Number: " + perfect);

        boolean abundant = isAbundantNumber(number);
        System.out.println("Abundant Number: " + abundant);

        boolean deficient = isDeficientNumber(number);
        System.out.println("Deficient Number: " + deficient);

        boolean strong = isStrongNumber(number);
        System.out.println("Strong Number: " + strong);

        scanner.close();
    }
}
