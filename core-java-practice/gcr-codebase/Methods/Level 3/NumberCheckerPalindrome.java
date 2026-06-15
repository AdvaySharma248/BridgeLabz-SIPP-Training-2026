import java.util.Scanner;

public class NumberCheckerPalindrome {

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

    public static int[] reverseDigits(int[] digits) {
        int[] reversed = new int[digits.length];
        for (int i = 0; i < digits.length; i++) {
            reversed[i] = digits[digits.length - 1 - i];
        }
        return reversed;
    }

    public static boolean compareArrays(int[] array1, int[] array2) {
        if (array1.length != array2.length) {
            return false;
        }
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] != array2[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrome(int[] digits) {
        int[] reversed = reverseDigits(digits);
        return compareArrays(digits, reversed);
    }

    public static boolean isDuckNumber(int[] digits) {
        for (int digit : digits) {
            if (digit == 0) {
                return true;
            }
        }
        return false;
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

        int[] reversed = reverseDigits(digits);
        System.out.print("Reversed digits: ");
        for (int i = 0; i < reversed.length; i++) {
            if (i < reversed.length - 1) {
                System.out.print(reversed[i] + ", ");
            } else {
                System.out.println(reversed[i]);
            }
        }

        boolean arraysEqual = compareArrays(digits, reversed);
        System.out.println("Original and reversed arrays are equal: " + arraysEqual);

        boolean palindrome = isPalindrome(digits);
        System.out.println("Palindrome Number: " + palindrome);

        boolean duck = isDuckNumber(digits);
        System.out.println("Duck Number: " + duck);

        scanner.close();
    }
}
