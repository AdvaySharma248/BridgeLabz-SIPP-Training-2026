import java.util.Scanner;

class Book {
    String title;
    String author;
    double price;

    Book() {
        title = "Unknown";
        author = "Unknown";
        price = 0.0;
    }

    Book(String t, String a, double p) {
        title = t;
        author = a;
        price = p;
    }

    void displayDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: " + price);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Using default constructor:");
        Book b1 = new Book();
        b1.displayDetails();

        System.out.print("Enter title: ");
        String t = sc.nextLine();
        System.out.print("Enter author: ");
        String a = sc.nextLine();
        System.out.print("Enter price: ");
        double p = sc.nextDouble();

        System.out.println("Using parameterized constructor:");
        Book b2 = new Book(t, a, p);
        b2.displayDetails();

        sc.close();
    }
}
