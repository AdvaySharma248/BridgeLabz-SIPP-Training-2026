import java.util.Scanner;

class Book {
    static String libraryName = "City Central Library";

    String title;
    String author;
    final String isbn;

    Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    static void displayLibraryName() {
        System.out.println("Library: " + libraryName);
    }

    void displayDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN: " + isbn);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Book.displayLibraryName();

        System.out.print("Enter title: ");
        String t = sc.nextLine();
        System.out.print("Enter author: ");
        String a = sc.nextLine();
        System.out.print("Enter ISBN: ");
        String i = sc.nextLine();

        Book b1 = new Book(t, a, i);

        if (b1 instanceof Book) {
            b1.displayDetails();
        }

        System.out.print("Enter title: ");
        sc.nextLine();
        String t2 = sc.nextLine();
        System.out.print("Enter author: ");
        String a2 = sc.nextLine();
        System.out.print("Enter ISBN: ");
        String i2 = sc.nextLine();

        Book b2 = new Book(t2, a2, i2);

        if (b2 instanceof Book) {
            b2.displayDetails();
        }

        sc.close();
    }
}
