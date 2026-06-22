import java.util.Scanner;

class LibraryBook {
    String title;
    String author;
    double price;
    boolean available;

    LibraryBook() {
        title = "Unknown";
        author = "Unknown";
        price = 0.0;
        available = true;
    }

    LibraryBook(String t, String a, double p) {
        title = t;
        author = a;
        price = p;
        available = true;
    }

    void borrow() {
        if (available) {
            available = false;
            System.out.println("You borrowed: " + title);
        } else {
            System.out.println("Sorry, " + title + " is not available.");
        }
    }

    void display() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: " + price);
        System.out.println("Available: " + available);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter title: ");
        String t = sc.nextLine();
        System.out.print("Enter author: ");
        String a = sc.nextLine();
        System.out.print("Enter price: ");
        double p = sc.nextDouble();

        LibraryBook book = new LibraryBook(t, a, p);
        book.display();

        book.borrow();
        book.display();

        book.borrow();

        sc.close();
    }
}
