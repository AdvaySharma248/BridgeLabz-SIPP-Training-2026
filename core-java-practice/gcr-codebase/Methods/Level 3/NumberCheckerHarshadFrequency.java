import java.util.Scanner;

public class NumberCheckerHarshadFrequency {

    public static int findDigitCount(int number) {
        int count = 0;
        int temp = number;
        if (temp == 0) {
            return 1;
        }
        if (temp < 0) {
            temp = -temp;
        }
        while (temp > 0) {
            count++;
            temp = temp / 10;
        }
        return count;
    }

    public static int[] storeDigits(int number) {
        int count = findDigitCount(number);
        int[] digits = new int[count];
        int temp = number;
        if (temp < 0) {
            temp = -temp;
        }
        for (int i = count - 1; i >= 0; i--) {
            digits[i] = temp % 10;
            temp = temp / 10;
        }
        return digits;
    }

    public static int findSumOfDigits(int[] digits) {
        int sum = 0;
        for (int digit : digits) {
            sum = sum + digit;
        }
        return sum;
    }

    public static double findSumOfSquaresOfDigits(int[] digits) {
        double sum = 0;
        for (int digit : digits) {
            sum = sum + Math.pow(digit, 2);
        }
        return sum;
    }

    public static boolean isHarshadNumber(int number, int[] digits) {
        int sumOfDigits = findSumOfDigits(digits);
        if (sumOfDigits == 0) {
            return false;
        }
        return number % sumOfDigits == 0;
    }

    public static int[][] findDigitFrequency(int[] digits) {
        int uniqueCount = 0;
        int[] seen = new int[digits.length];
        for (int i = 0; i < digits.length; i++) {
            boolean found = false;
            for (int j = 0; j < uniqueCount; j++) {
                if (seen[j] == digits[i]) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                seen[uniqueCount] = digits[i];
                uniqueCount++;
            }
        }

        int[][] frequency = new int[uniqueCount][2];
        int index = 0;
        for (int i = 0; i < uniqueCount; i++) {
            frequency[index][0] = seen[i];
            int count = 0;
            for (int digit : digits) {
                if (digit == seen[i]) {
                    count++;
                }
            }
            frequency[index][1] = count;
            index++;
        }
        return frequency;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        int absNumber = number;
        if (absNumber < 0) {
            absNumber = -absNumber;
        }

        int[] digits = storeDigits(absNumber);

        System.out.print("Digits: ");
        for (int i = 0; i < digits.length; i++) {
            if (i < digits.length - 1) {
                System.out.print(digits[i] + ", ");
            } else {
                System.out.println(digits[i]);
            }
        }

        int sumOfDigits = findSumOfDigits(digits);
        System.out.println("Sum of digits: " + sumOfDigits);

        double sumOfSquares = findSumOfSquaresOfDigits(digits);
        System.out.println("Sum of squares of digits: " + sumOfSquares);

        boolean harshad = isHarshadNumber(absNumber, digits);
        System.out.println("Harshad Number: " + harshad);

        int[][] frequency = findDigitFrequency(digits);
        System.out.println("Digit Frequency:");
        for (int i = 0; i < frequency.length; i++) {
            System.out.println("Digit " + frequency[i][0] + " appears " + frequency[i][1] + " time(s)");
        }

        scanner.close();
    }
}
