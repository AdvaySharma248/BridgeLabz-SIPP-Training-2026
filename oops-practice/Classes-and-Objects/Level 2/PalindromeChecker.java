import java.util.Scanner;

public class PalindromeChecker {
    String text;

    boolean isPalindrome() {
        String reversed = "";
        for (int i = text.length() - 1; i >= 0; i--) {
            reversed = reversed + text.charAt(i);
        }
        return text.equalsIgnoreCase(reversed);
    }

    void displayResult() {
        if (isPalindrome()) {
            System.out.println(text + " is a palindrome.");
        } else {
            System.out.println(text + " is not a palindrome.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String t = sc.nextLine();

        PalindromeChecker checker = new PalindromeChecker();
        checker.text = t;

        checker.displayResult();

        sc.close();
    }
}
