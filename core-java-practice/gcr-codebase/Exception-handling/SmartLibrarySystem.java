import java.util.Scanner;

public class SmartLibrarySystem {

    static String books[] = {"Java", "Python", null, "C++"};

    static int getBookLength(int index) {
        try {
            return books[index].length();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index! Library has only " + books.length + " entries.");
            return -1;
        } catch (NullPointerException e) {
            System.out.println("Book at index " + index + " is not available (null entry).");
            return -1;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter book index: ");
        int index = sc.nextInt();
        int length = getBookLength(index);
        if (length != -1) {
            System.out.println("Book: " + books[index] + ", Length: " + length);
        }
        sc.close();
    }
}
