import java.util.Scanner;

class Product {
    String productName;
    double price;
    static int totalProducts = 0;

    Product(String n, double p) {
        productName = n;
        price = p;
        totalProducts++;
    }

    void displayProductDetails() {
        System.out.println("Product: " + productName);
        System.out.println("Price: " + price);
    }

    static void displayTotalProducts() {
        System.out.println("Total Products: " + totalProducts);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter product 1 name: ");
        String n1 = sc.nextLine();
        System.out.print("Enter product 1 price: ");
        double p1 = sc.nextDouble();
        sc.nextLine();

        Product prod1 = new Product(n1, p1);
        prod1.displayProductDetails();

        System.out.print("Enter product 2 name: ");
        String n2 = sc.nextLine();
        System.out.print("Enter product 2 price: ");
        double p2 = sc.nextDouble();

        Product prod2 = new Product(n2, p2);
        prod2.displayProductDetails();

        Product.displayTotalProducts();

        sc.close();
    }
}
