package interfaces;

interface CouponValidator {
    // Requirement: abstract method
    boolean validateCoupon(String code);

    // Requirement: static method
    static boolean isLengthValid(String code) {
        // Assume valid coupon length is between 5 and 10 characters
        return code != null && code.length() >= 5 && code.length() <= 10;
    }
}

// Requirement: Implement the interface in a class ShoppingCart
class ShoppingCart implements CouponValidator {
    @Override
    public boolean validateCoupon(String code) {
        // Beginner level simple validation: coupon must start with "SAVE" or "DISC"
        if (code.startsWith("SAVE") || code.startsWith("DISC")) {
            return true;
        }
        return false;
    }
}

public class CouponValidatorSystem {
    public static void main(String[] args) {
        // Requirement: Store coupon codes in a String[]
        String[] coupons = {"SAVE10", "DISC50", "HELLO", "SAVEBIGGER", "OFF5"};

        ShoppingCart cart = new ShoppingCart();

        System.out.println("--- Online Coupon Validator ---");
        for (String code : coupons) {
            // Check length using static method from interface
            boolean lengthOk = CouponValidator.isLengthValid(code);
            
            // Check validity using implemented method
            boolean isValid = cart.validateCoupon(code);

            System.out.print("Coupon: " + code + " | ");
            if (lengthOk && isValid) {
                System.out.println("Status: VALID");
            } else {
                System.out.print("Status: INVALID (");
                if (!lengthOk) System.out.print("Invalid Length ");
                if (!isValid) System.out.print("Invalid Format");
                System.out.println(")");
            }
        }
    }
}
