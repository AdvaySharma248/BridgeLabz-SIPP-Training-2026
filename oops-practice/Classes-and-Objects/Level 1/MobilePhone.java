import java.util.Scanner;

public class MobilePhone {
    String brand;
    String model;
    double price;

    void displayDetails() {
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Price: " + price);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter brand: ");
        String b = sc.nextLine();

        System.out.print("Enter model: ");
        String m = sc.nextLine();

        System.out.print("Enter price: ");
        double p = sc.nextDouble();

        MobilePhone phone = new MobilePhone();
        phone.brand = b;
        phone.model = m;
        phone.price = p;

        phone.displayDetails();

        sc.close();
    }
}
