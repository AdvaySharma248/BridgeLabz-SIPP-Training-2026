import java.util.Scanner;

public class NaturalNumberSumCalculator {

    public static int calculateSumOfNaturalNumbers(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum = sum + i;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the value of n: ");
        int n = scanner.nextInt();

        int sum = calculateSumOfNaturalNumbers(n);

        System.out.println("The sum of first " + n + " natural numbers is " + sum);

        scanner.close();
    }
}
