import java.util.Scanner;

class BankAccount {
    static String bankName = "National Bank";
    static int totalAccounts = 0;

    String accountHolderName;
    String accountNumber;
    double balance;

    BankAccount(String accountHolderName, String accountNumber, double balance) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = balance;
        totalAccounts++;
    }

    static void getTotalAccounts() {
        System.out.println("Total Accounts: " + totalAccounts);
    }

    void displayDetails() {
        System.out.println("Bank: " + bankName);
        System.out.println("Holder: " + accountHolderName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter holder name: ");
        String n = sc.nextLine();
        System.out.print("Enter account number: ");
        String a = sc.nextLine();
        System.out.print("Enter balance: ");
        double b = sc.nextDouble();

        BankAccount acc1 = new BankAccount(n, a, b);

        if (acc1 instanceof BankAccount) {
            acc1.displayDetails();
        }

        sc.nextLine();
        System.out.print("Enter holder name: ");
        String n2 = sc.nextLine();
        System.out.print("Enter account number: ");
        String a2 = sc.nextLine();
        System.out.print("Enter balance: ");
        double b2 = sc.nextDouble();

        BankAccount acc2 = new BankAccount(n2, a2, b2);

        if (acc2 instanceof BankAccount) {
            acc2.displayDetails();
        }

        BankAccount.getTotalAccounts();

        sc.close();
    }
}
