abstract class LibraryItem {
    private int itemId;
    private String title;
    private String author;

    int getItemId() {
        return itemId;
    }

    void setItemId(int itemId) {
        this.itemId = itemId;
    }

    String getTitle() {
        return title;
    }

    void setTitle(String title) {
        this.title = title;
    }

    String getAuthor() {
        return author;
    }

    void setAuthor(String author) {
        this.author = author;
    }

    abstract int getLoanDuration();

    void displayItemDetails() {
        System.out.println("Item ID: " + itemId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
    }
}

class Book extends LibraryItem {
    int getLoanDuration() {
        return 14;
    }
}

class Magazine extends LibraryItem {
    int getLoanDuration() {
        return 7;
    }
}

class DVD extends LibraryItem {
    int getLoanDuration() {
        return 3;
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Book book = new Book();
        book.setItemId(1);
        book.setTitle("Java Programming");
        book.setAuthor("James Gosling");

        Magazine magazine = new Magazine();
        magazine.setItemId(2);
        magazine.setTitle("Tech Today");
        magazine.setAuthor("Tech Team");

        DVD dvd = new DVD();
        dvd.setItemId(3);
        dvd.setTitle("Inception");
        dvd.setAuthor("Christopher Nolan");

        System.out.println("Book Details:");
        book.displayItemDetails();
        System.out.println("Loan Duration: " + book.getLoanDuration() + " days");
        System.out.println();

        System.out.println("Magazine Details:");
        magazine.displayItemDetails();
        System.out.println("Loan Duration: " + magazine.getLoanDuration() + " days");
        System.out.println();

        System.out.println("DVD Details:");
        dvd.displayItemDetails();
        System.out.println("Loan Duration: " + dvd.getLoanDuration() + " days");
    }
}
