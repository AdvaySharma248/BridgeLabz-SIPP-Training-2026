import java.util.Scanner;

class BankAccount {
    static int totalAccounts = 0;

    String accountNumber;
    String holder;
    double balance;
    String[] transactions;
    int transactionCount;

    BankAccount(String accountNumber, String holder, double balance) {
        this.accountNumber = accountNumber;
        this.holder = holder;
        this.balance = balance;
        transactions = new String[20];
        transactionCount = 0;
        totalAccounts++;
    }

    void deposit(double amount) {
        balance = balance + amount;
        transactions[transactionCount] = "Deposited: " + amount;
        transactionCount++;
        System.out.println("Deposited " + amount + " to " + accountNumber);
    }

    void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Overdraft! Not enough balance in " + accountNumber);
            transactions[transactionCount] = "Failed withdrawal: " + amount + " (insufficient funds)";
            transactionCount++;
        } else {
            balance = balance - amount;
            transactions[transactionCount] = "Withdrawn: " + amount;
            transactionCount++;
            System.out.println("Withdrawn " + amount + " from " + accountNumber);
        }
    }

    void getStatement() {
        System.out.println("Statement for " + accountNumber + " (" + holder + ")");
        System.out.println("Current Balance: " + balance);
        for (int i = 0; i < transactionCount; i++) {
            System.out.println("  " + transactions[i]);
        }
    }

    static void displayTotalAccounts() {
        System.out.println("Total accounts: " + totalAccounts);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BankAccount acc1 = new BankAccount("A001", "Alice", 5000);
        BankAccount acc2 = new BankAccount("A002", "Bob", 3000);
        BankAccount acc3 = new BankAccount("A003", "Charlie", 7000);

        BankAccount.displayTotalAccounts();

        System.out.println("\nTransactions for Alice:");
        acc1.deposit(2000);
        acc1.withdraw(1000);
        acc1.deposit(500);
        acc1.withdraw(8000);
        acc1.withdraw(300);

        System.out.println("\nTransactions for Bob:");
        acc2.deposit(1000);
        acc2.withdraw(500);
        acc2.deposit(200);
        acc2.withdraw(4000);
        acc2.withdraw(100);

        System.out.println("\nTransactions for Charlie:");
        acc3.deposit(3000);
        acc3.withdraw(2000);
        acc3.deposit(1500);
        acc3.withdraw(500);
        acc3.withdraw(10000);

        System.out.println();
        acc1.getStatement();
        System.out.println();
        acc2.getStatement();
        System.out.println();
        acc3.getStatement();

        sc.close();
    }
}
