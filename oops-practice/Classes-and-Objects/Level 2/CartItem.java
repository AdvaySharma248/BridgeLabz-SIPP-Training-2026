import java.util.Scanner;

public class CartItem {
    String itemName;
    double price;
    int quantity;

    static String[] itemNames = new String[10];
    static double[] itemPrices = new double[10];
    static int[] itemQuantities = new int[10];
    static int count = 0;

    void addItem(String name, double p, int qty) {
        itemNames[count] = name;
        itemPrices[count] = p;
        itemQuantities[count] = qty;
        count++;
        System.out.println(name + " added to cart.");
    }

    void removeItem(String name) {
        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (itemNames[i].equalsIgnoreCase(name)) {
                for (int j = i; j < count - 1; j++) {
                    itemNames[j] = itemNames[j + 1];
                    itemPrices[j] = itemPrices[j + 1];
                    itemQuantities[j] = itemQuantities[j + 1];
                }
                count--;
                found = true;
                System.out.println(name + " removed from cart.");
                break;
            }
        }
        if (!found) {
            System.out.println(name + " not found in cart.");
        }
    }

    void displayTotal() {
        double total = 0;
        System.out.println("Cart Items:");
        for (int i = 0; i < count; i++) {
            System.out.println(itemNames[i] + " - " + itemPrices[i] + " x " + itemQuantities[i]);
            total = total + (itemPrices[i] * itemQuantities[i]);
        }
        System.out.println("Total Cost: " + total);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CartItem cart = new CartItem();

        System.out.print("How many items do you want to add? ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter item name: ");
            String name = sc.nextLine();
            System.out.print("Enter price: ");
            double p = sc.nextDouble();
            System.out.print("Enter quantity: ");
            int qty = sc.nextInt();
            sc.nextLine();
            cart.addItem(name, p, qty);
        }

        System.out.print("Enter item name to remove (or type 'none'): ");
        String remove = sc.nextLine();
        if (!remove.equalsIgnoreCase("none")) {
            cart.removeItem(remove);
        }

        cart.displayTotal();

        sc.close();
    }
}
