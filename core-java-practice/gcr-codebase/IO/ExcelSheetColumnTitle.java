import java.util.Scanner;

public class ExcelSheetColumnTitle {

    public static String convertToTitle(int columnNumber) {
        String result = "";
        while (columnNumber > 0) {
            columnNumber--;
            int remainder = columnNumber % 26;
            char ch = (char) ('A' + remainder);
            result = ch + result;
            columnNumber = columnNumber / 26;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the column number: ");
        int columnNumber = scanner.nextInt();

        String title = convertToTitle(columnNumber);
        System.out.println("Excel column title: " + title);

        scanner.close();
    }
}
