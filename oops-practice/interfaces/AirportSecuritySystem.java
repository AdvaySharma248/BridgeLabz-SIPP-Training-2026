package interfaces;

interface LuggageScanner {
    boolean scanLuggage(boolean hasProhibitedItems);
    
    default void displaySecurityGuidelines() {
        System.out.println("Luggage Guidelines: No sharp objects, flammables, or liquids > 100ml.");
    }
}

interface PassportVerifier {
    boolean verifyPassport(String passportNo);

    default void displaySecurityGuidelines() {
        System.out.println("Passport Guidelines: Must have a valid passport with at least 6 months validity.");
    }

    // Requirement: static method isPassportNumberValid
    static boolean isPassportNumberValid(String passportNo) {
        // Simple beginner level check: Passport should be 8 characters long and start with 'P'
        return passportNo != null && passportNo.length() == 8 && passportNo.startsWith("P");
    }
}

// Requirement: class AirportSecuritySystem implementing both interfaces
class AirportSecuritySystem implements LuggageScanner, PassportVerifier {
    
    @Override
    public boolean scanLuggage(boolean hasProhibitedItems) {
        return !hasProhibitedItems;
    }

    @Override
    public boolean verifyPassport(String passportNo) {
        return PassportVerifier.isPassportNumberValid(passportNo);
    }

    // Resolving conflict
    @Override
    public void displaySecurityGuidelines() {
        System.out.println("--- Global Airport Security Guidelines ---");
        LuggageScanner.super.displaySecurityGuidelines();
        PassportVerifier.super.displaySecurityGuidelines();
    }
}

public class AirportSecurityMain {
    public static void main(String[] args) {
        // Requirement: Store passenger details in arrays
        String[] passengerNames = {"John Doe", "Jane Smith", "Bad Actor", "Tom Hardy"};
        String[] passportNumbers = {"P1234567", "P9876543", "ABC12345", "P5556667"};
        boolean[] hasProhibitedItems = {false, false, true, false};

        AirportSecuritySystem security = new AirportSecuritySystem();
        security.displaySecurityGuidelines();

        System.out.println("\n--- Security Checkpoint ---");
        for (int i = 0; i < passengerNames.length; i++) {
            System.out.println("Passenger: " + passengerNames[i]);
            
            boolean passportOk = security.verifyPassport(passportNumbers[i]);
            boolean luggageOk = security.scanLuggage(hasProhibitedItems[i]);

            if (passportOk && luggageOk) {
                System.out.println("Status: CLEAR - Can board the flight.");
            } else {
                System.out.print("Status: REJECTED - ");
                if (!passportOk) System.out.print("Invalid Passport. ");
                if (!luggageOk) System.out.print("Prohibited items found in luggage.");
                System.out.println();
            }
            System.out.println("-------------------------");
        }
    }
}
