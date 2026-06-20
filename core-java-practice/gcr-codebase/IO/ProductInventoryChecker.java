import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ProductInventoryChecker {

    public static void main(String[] args) {
        String fileName = "inventory.txt";

        try {
            File file = new File(fileName);
            Scanner fileScanner = new Scanner(file);

            System.out.println("Inventory Status:");
            System.out.println("----------------------------------------");

            int outOfStockCount = 0;
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                int dashIndex = line.lastIndexOf("-");

                if (dashIndex != -1) {
                    String productName = line.substring(0, dashIndex).trim();
                    String quantityStr = line.substring(dashIndex + 1).trim();
                    int quantity = Integer.parseInt(quantityStr);

                    if (quantity == 0) {
                        System.out.println(productName + " is out of stock");
                        outOfStockCount++;
                    } else {
                        System.out.println(productName + " - Available: " + quantity);
                    }
                }
            }

            System.out.println("----------------------------------------");
            System.out.println("Total out of stock items: " + outOfStockCount);

            fileScanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
            System.out.println("Please create the inventory file first");
        }
    }
}
