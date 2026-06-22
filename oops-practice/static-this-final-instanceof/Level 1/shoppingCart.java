import java.util.Scanner;

class Product {
    static double discount = 10.0;

    String productName;
    double price;
    int quantity;
    final int productID;

    Product(String productName, double price, int quantity, int productID) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.productID = productID;
    }

    static void updateDiscount(double newDiscount) {
        discount = newDiscount;
        System.out.println("Discount updated to: " + discount + "%");
    }

    double getDiscountedPrice() {
        return price - (price * discount / 100);
    }

    void displayDetails() {
        System.out.println("Product ID: " + productID);
        System.out.println("Name: " + productName);
        System.out.println("Price: " + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("Discounted Price: " + getDiscountedPrice());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter product name: ");
        String n = sc.nextLine();
        System.out.print("Enter price: ");
        double p = sc.nextDouble();
        System.out.print("Enter quantity: ");
        int q = sc.nextInt();
        System.out.print("Enter product ID: ");
        int id = sc.nextInt();

        Product prod = new Product(n, p, q, id);

        if (prod instanceof Product) {
            prod.displayDetails();
        }

        System.out.print("Enter new discount percentage: ");
        double nd = sc.nextDouble();
        Product.updateDiscount(nd);

        if (prod instanceof Product) {
            prod.displayDetails();
        }

        sc.close();
    }
}
