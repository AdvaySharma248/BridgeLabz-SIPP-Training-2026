import java.util.Scanner;

public class ReverseBits {

    public static int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result = result << 1;
            result = result | (n & 1);
            n = n >> 1;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int n = scanner.nextInt();

        int reversed = reverseBits(n);
        System.out.println("Reversed bits result: " + reversed);

        scanner.close();
    }
}
