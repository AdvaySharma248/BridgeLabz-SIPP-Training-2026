import java.util.Scanner;

class BankAccount {
    public String accountNumber;
    protected String accountHolder;
    private double balance;

    BankAccount(String an, String ah, double b) {
        accountNumber = an;
        accountHolder = ah;
        balance = b;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double b) {
        balance = b;
    }

    void display() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: " + balance);
    }
}

class SavingsAccount extends BankAccount {
    double interestRate;

    SavingsAccount(String an, String ah, double b, double ir) {
        super(an, ah, b);
        interestRate = ir;
    }

    void showSavingsDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: " + getBalance());
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}

public class BankAccountManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter account number: ");
        String an = sc.nextLine();
        System.out.print("Enter account holder: ");
        String ah = sc.nextLine();
        System.out.print("Enter balance: ");
        double b = sc.nextDouble();

        BankAccount acc = new BankAccount(an, ah, b);
        acc.display();

        System.out.print("Enter new balance: ");
        double nb = sc.nextDouble();
        acc.setBalance(nb);
        System.out.println("Updated Balance: " + acc.getBalance());

        System.out.print("Enter interest rate: ");
        double ir = sc.nextDouble();

        SavingsAccount sa = new SavingsAccount(an + "-S", ah + " Savings", b, ir);
        sa.showSavingsDetails();

        sc.close();
    }
}
