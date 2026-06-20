import java.util.Scanner;

public class NumberOfOneBits {

    public static int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count = count + (n & 1);
            n = n >>> 1;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int n = scanner.nextInt();

        int ones = hammingWeight(n);
        System.out.println("Number of 1 bits: " + ones);

        scanner.close();
    }
}
