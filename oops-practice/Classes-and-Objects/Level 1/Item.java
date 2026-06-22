import java.util.Scanner;

public class Item {
    String itemCode;
    String itemName;
    double price;

    void displayDetails() {
        System.out.println("Item Code: " + itemCode);
        System.out.println("Item Name: " + itemName);
        System.out.println("Price: " + price);
    }

    double calculateTotalCost(int quantity) {
        return price * quantity;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter item code: ");
        String code = sc.nextLine();

        System.out.print("Enter item name: ");
        String name = sc.nextLine();

        System.out.print("Enter price: ");
        double p = sc.nextDouble();

        System.out.print("Enter quantity: ");
        int qty = sc.nextInt();

        Item item = new Item();
        item.itemCode = code;
        item.itemName = name;
        item.price = p;

        item.displayDetails();
        System.out.println("Total Cost for " + qty + " items: " + item.calculateTotalCost(qty));

        sc.close();
    }
}
