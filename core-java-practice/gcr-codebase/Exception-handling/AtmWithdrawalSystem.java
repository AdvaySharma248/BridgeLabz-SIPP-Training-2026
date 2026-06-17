import java.util.Scanner;

class InsufficientBalanceException extends Exception {
    private double balance;
    private double withdrawalAmount;

    public InsufficientBalanceException(String message, double balance, double withdrawalAmount) {
        super(message);
        this.balance = balance;
        this.withdrawalAmount = withdrawalAmount;
    }

    public double getBalance() {
        return balance;
    }

    public double getWithdrawalAmount() {
        return withdrawalAmount;
    }
}

public class AtmWithdrawalSystem {
    private double balance;

    public AtmWithdrawalSystem(double balance) {
        this.balance = balance;
    }

    void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > balance) {
            throw new InsufficientBalanceException(
                "Withdrawal of Rs." + amount + " failed. Available balance: Rs." + balance,
                balance,
                amount
            );
        }
        balance -= amount;
        System.out.println("Withdrawal of Rs." + amount + " successful. Remaining balance: Rs." + balance);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AtmWithdrawalSystem account = new AtmWithdrawalSystem(5000);
        System.out.println("Current balance: Rs.5000");
        System.out.print("Enter withdrawal amount: ");
        double amount = sc.nextDouble();
        try {
            account.withdraw(amount);
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
            System.out.println("Shortfall: Rs." + (e.getWithdrawalAmount() - e.getBalance()));
        }
        sc.close();
    }
}
