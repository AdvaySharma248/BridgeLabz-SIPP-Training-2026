import java.util.Scanner;

public class FactorsArrayCalculator {

    public static int[] findFactors(int number) {
        int count = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                count++;
            }
        }
        int[] factors = new int[count];
        int index = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                factors[index] = i;
                index++;
            }
        }
        return factors;
    }

    public static int findSumOfFactors(int[] factors) {
        int sum = 0;
        for (int factor : factors) {
            sum = sum + factor;
        }
        return sum;
    }

    public static long findProductOfFactors(int[] factors) {
        long product = 1;
        for (int factor : factors) {
            product = product * factor;
        }
        return product;
    }

    public static double findSumOfSquareOfFactors(int[] factors) {
        double sumOfSquares = 0;
        for (int factor : factors) {
            sumOfSquares = sumOfSquares + Math.pow(factor, 2);
        }
        return sumOfSquares;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        int[] factors = findFactors(number);

        System.out.print("The factors of " + number + " are: ");
        for (int i = 0; i < factors.length; i++) {
            if (i < factors.length - 1) {
                System.out.print(factors[i] + ", ");
            } else {
                System.out.println(factors[i]);
            }
        }

        int sum = findSumOfFactors(factors);
        System.out.println("The sum of factors is " + sum);

        long product = findProductOfFactors(factors);
        System.out.println("The product of factors is " + product);

        double sumOfSquares = findSumOfSquareOfFactors(factors);
        System.out.println("The sum of squares of factors is " + sumOfSquares);

        scanner.close();
    }
}
