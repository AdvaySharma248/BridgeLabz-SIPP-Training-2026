import java.util.Scanner;

public class PasswordStrengthChecker {

    static void checkPassword(String password) {
        try {
            if (password == null) {
                throw new IllegalArgumentException("Password cannot be null");
            }
            if (password.isEmpty()) {
                throw new IllegalArgumentException("Password cannot be empty");
            }
            if (password.length() < 8) {
                throw new IllegalArgumentException("Password must be at least 8 characters long");
            }
            if (!Character.isUpperCase(password.charAt(0))) {
                throw new IllegalArgumentException("First character must be uppercase");
            }
            if (!Character.isDigit(password.charAt(password.length() - 1))) {
                throw new IllegalArgumentException("Last character must be a digit");
            }
            boolean hasSpecial = false;
            String specialChars = "@#$%&*";
            for (int i = 0; i < password.length(); i++) {
                if (specialChars.indexOf(password.charAt(i)) != -1) {
                    hasSpecial = true;
                    break;
                }
            }
            if (!hasSpecial) {
                throw new IllegalArgumentException("Password must contain at least one special character (@, #, $, %, &, *)");
            }
            System.out.println("Password is strong!");
        } catch (IllegalArgumentException e) {
            System.out.println("Weak password: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter password: ");
        String password = sc.nextLine();
        checkPassword(password);

        checkPassword(null);
        checkPassword("");
        checkPassword("short1");
        checkPassword("lowercase@1");
        checkPassword("NoSpecial1");
        checkPassword("NoDigitAtEnd@");
        checkPassword("Good@Pass1");
        sc.close();
    }
}
