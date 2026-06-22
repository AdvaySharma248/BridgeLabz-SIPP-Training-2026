import java.util.Scanner;

class HotelBooking {
    String guestName;
    String roomType;
    int nights;

    HotelBooking() {
        guestName = "Guest";
        roomType = "Standard";
        nights = 1;
    }

    HotelBooking(String g, String r, int n) {
        guestName = g;
        roomType = r;
        nights = n;
    }

    HotelBooking(HotelBooking other) {
        guestName = other.guestName;
        roomType = other.roomType;
        nights = other.nights;
    }

    void display() {
        System.out.println("Guest Name: " + guestName);
        System.out.println("Room Type: " + roomType);
        System.out.println("Nights: " + nights);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Default booking:");
        HotelBooking b1 = new HotelBooking();
        b1.display();

        System.out.print("Enter guest name: ");
        String g = sc.nextLine();
        System.out.print("Enter room type: ");
        String r = sc.nextLine();
        System.out.print("Enter number of nights: ");
        int n = sc.nextInt();

        System.out.println("Parameterized booking:");
        HotelBooking b2 = new HotelBooking(g, r, n);
        b2.display();

        System.out.println("Copy booking:");
        HotelBooking b3 = new HotelBooking(b2);
        b3.display();

        sc.close();
    }
}
