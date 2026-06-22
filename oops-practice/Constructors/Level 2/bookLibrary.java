import java.util.Scanner;

class Book {
    public String ISBN;
    protected String title;
    private String author;

    Book(String isbn, String t, String a) {
        ISBN = isbn;
        title = t;
        author = a;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String a) {
        author = a;
    }

    void display() {
        System.out.println("ISBN: " + ISBN);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
    }
}

class EBook extends Book {
    double fileSize;

    EBook(String isbn, String t, String a, double fs) {
        super(isbn, t, a);
        fileSize = fs;
    }

    void showEBookDetails() {
        System.out.println("ISBN: " + ISBN);
        System.out.println("Title: " + title);
        System.out.println("Author: " + getAuthor());
        System.out.println("File Size: " + fileSize + " MB");
    }
}

class BookLibrary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter ISBN: ");
        String isbn = sc.nextLine();
        System.out.print("Enter title: ");
        String t = sc.nextLine();
        System.out.print("Enter author: ");
        String a = sc.nextLine();

        Book b = new Book(isbn, t, a);
        b.display();

        System.out.print("Enter new author name: ");
        String na = sc.nextLine();
        b.setAuthor(na);
        System.out.println("Updated author: " + b.getAuthor());

        System.out.print("Enter eBook file size (MB): ");
        double fs = sc.nextDouble();

        EBook eb = new EBook(isbn + "-E", t + " eBook", na, fs);
        eb.showEBookDetails();

        sc.close();
    }
}
