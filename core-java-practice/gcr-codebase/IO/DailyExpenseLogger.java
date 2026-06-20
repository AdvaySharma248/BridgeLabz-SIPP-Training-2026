import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Scanner;

public class DailyExpenseLogger {

    public static void logExpense(String category, int amount) throws IOException {
        FileWriter fileWriter = new FileWriter("expenses.txt", true);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.println(category + " - " + amount);
        printWriter.close();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("How many expenses do you want to log: ");
        int numberOfExpenses = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numberOfExpenses; i++) {
            System.out.print("Enter expense category: ");
            String category = scanner.nextLine();

            System.out.print("Enter amount: ");
            int amount = scanner.nextInt();
            scanner.nextLine();

            try {
                logExpense(category, amount);
                System.out.println("Expense logged successfully");
            } catch (IOException e) {
                System.out.println("Error logging expense: " + e.getMessage());
            }
        }

        System.out.println("All expenses saved to expenses.txt");
        scanner.close();
    }
}
