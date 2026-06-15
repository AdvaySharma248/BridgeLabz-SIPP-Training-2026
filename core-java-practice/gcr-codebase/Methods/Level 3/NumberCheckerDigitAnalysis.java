import java.util.Scanner;

public class NumberCheckerDigitAnalysis {

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

    public static boolean isDuckNumber(int[] digits) {
        for (int digit : digits) {
            if (digit == 0) {
                return true;
            }
        }
        return false;
    }

    public static boolean isArmstrongNumber(int number, int[] digits) {
        int numberOfDigits = digits.length;
        int sum = 0;
        for (int digit : digits) {
            sum = sum + (int) Math.pow(digit, numberOfDigits);
        }
        return sum == number;
    }

    public static int[] findLargestAndSecondLargest(int[] digits) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        for (int digit : digits) {
            if (digit > largest) {
                secondLargest = largest;
                largest = digit;
            } else if (digit > secondLargest && digit != largest) {
                secondLargest = digit;
            }
        }
        int[] result = {largest, secondLargest};
        return result;
    }

    public static int[] findSmallestAndSecondSmallest(int[] digits) {
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;
        for (int digit : digits) {
            if (digit < smallest) {
                secondSmallest = smallest;
                smallest = digit;
            } else if (digit < secondSmallest && digit != smallest) {
                secondSmallest = digit;
            }
        }
        int[] result = {smallest, secondSmallest};
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        int absNumber = number;
        if (absNumber < 0) {
            absNumber = -absNumber;
        }

        int digitCount = findDigitCount(absNumber);
        System.out.println("Number of digits: " + digitCount);

        int[] digits = storeDigits(absNumber);
        System.out.print("Digits: ");
        for (int i = 0; i < digits.length; i++) {
            if (i < digits.length - 1) {
                System.out.print(digits[i] + ", ");
            } else {
                System.out.println(digits[i]);
            }
        }

        boolean duck = isDuckNumber(digits);
        System.out.println("Duck Number: " + duck);

        boolean armstrong = isArmstrongNumber(absNumber, digits);
        System.out.println("Armstrong Number: " + armstrong);

        int[] largestResult = findLargestAndSecondLargest(digits);
        System.out.println("Largest digit: " + largestResult[0]);
        System.out.println("Second largest digit: " + largestResult[1]);

        int[] smallestResult = findSmallestAndSecondSmallest(digits);
        System.out.println("Smallest digit: " + smallestResult[0]);
        System.out.println("Second smallest digit: " + smallestResult[1]);

        scanner.close();
    }
}
