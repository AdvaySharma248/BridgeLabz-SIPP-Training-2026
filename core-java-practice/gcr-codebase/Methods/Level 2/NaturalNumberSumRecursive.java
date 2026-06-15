import java.util.Scanner;

public class NaturalNumberSumRecursive {

    public static int calculateSumRecursive(int n) {
        if (n == 1) {
            return 1;
        }
        return n + calculateSumRecursive(n - 1);
    }

    public static int calculateSumFormula(int n) {
        return (n * (n + 1)) / 2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a natural number: ");
        int n = scanner.nextInt();

        if (n < 1) {
            System.out.println("Please enter a valid natural number");
        } else {
            int sumRecursive = calculateSumRecursive(n);
            int sumFormula = calculateSumFormula(n);

            System.out.println("Sum using recursion: " + sumRecursive);
            System.out.println("Sum using formula n*(n+1)/2: " + sumFormula);

            if (sumRecursive == sumFormula) {
                System.out.println("Both results are correct and match");
            } else {
                System.out.println("The results do not match");
            }
        }

        scanner.close();
    }
}
