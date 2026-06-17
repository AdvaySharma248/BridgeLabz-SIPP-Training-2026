import java.util.Scanner;

class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

public class HospitalBillingSystem {

    static double calculatePerItemCost(double totalBill, int numberOfItems) {
        return totalBill / numberOfItems;
    }

    static String getPatientRecord(String[] patients, int index) {
        return patients[index];
    }

    static void processPayment(double billAmount, double paymentAmount) throws InsufficientFundsException {
        if (paymentAmount < billAmount) {
            throw new InsufficientFundsException("Payment of " + paymentAmount + " is less than bill amount " + billAmount);
        }
        System.out.println("Payment successful. Change: " + (paymentAmount - billAmount));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] patients = {"John", "Alice", "Bob", "Diana"};
        double totalBill = 5000.0;

        try {
            System.out.print("Enter number of items in bill: ");
            String itemInput = sc.nextLine();
            int numberOfItems = Integer.parseInt(itemInput);
            double perItemCost = calculatePerItemCost(totalBill, numberOfItems);
            System.out.println("Per item cost: " + perItemCost);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input! Please enter a valid number for items.");
        } catch (ArithmeticException e) {
            System.out.println("Cannot calculate per item cost: Bill has zero items.");
        }

        try {
            System.out.print("Enter patient index: ");
            int index = Integer.parseInt(sc.nextLine());
            String patient = getPatientRecord(patients, index);
            System.out.println("Patient record: " + patient);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid patient index! Only 0 to " + (patients.length - 1) + " are valid.");
        } catch (NumberFormatException e) {
            System.out.println("Invalid input! Please enter a numeric index.");
        }

        try {
            System.out.print("Enter payment amount: ");
            double payment = Double.parseDouble(sc.nextLine());
            processPayment(totalBill, payment);
        } catch (InsufficientFundsException e) {
            System.out.println("Payment failed: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Invalid payment amount entered.");
        }

        sc.close();
    }
}
