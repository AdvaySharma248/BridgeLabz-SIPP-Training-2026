abstract class BankAccount {
    private int accountNumber;
    private String holderName;
    private double balance;

    int getAccountNumber() {
        return accountNumber;
    }

    void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    String getHolderName() {
        return holderName;
    }

    void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    double getBalance() {
        return balance;
    }

    void setBalance(double balance) {
        this.balance = balance;
    }

    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        }
    }

    void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Holder Name: " + holderName);
        System.out.println("Balance: " + balance);
    }

    abstract double calculateInterest();
}

class SavingsAccount extends BankAccount {
    private double interestRate;

    double getInterestRate() {
        return interestRate;
    }

    void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    double calculateInterest() {
        return getBalance() * interestRate / 100;
    }
}

class CurrentAccount extends BankAccount {
    private double monthlyBonusRate;

    double getMonthlyBonusRate() {
        return monthlyBonusRate;
    }

    void setMonthlyBonusRate(double monthlyBonusRate) {
        this.monthlyBonusRate = monthlyBonusRate;
    }

    double calculateInterest() {
        return getBalance() * monthlyBonusRate / 100;
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        SavingsAccount savings = new SavingsAccount();
        savings.setAccountNumber(12345);
        savings.setHolderName("Alice");
        savings.setBalance(10000);
        savings.setInterestRate(5);

        CurrentAccount current = new CurrentAccount();
        current.setAccountNumber(67890);
        current.setHolderName("Bob");
        current.setBalance(20000);
        current.setMonthlyBonusRate(2);

        savings.deposit(5000);
        savings.withdraw(2000);

        current.deposit(3000);
        current.withdraw(1000);

        System.out.println("Savings Account Details:");
        savings.displayAccountDetails();
        System.out.println("Interest: " + savings.calculateInterest());
        System.out.println();

        System.out.println("Current Account Details:");
        current.displayAccountDetails();
        System.out.println("Interest: " + current.calculateInterest());
    }
}
