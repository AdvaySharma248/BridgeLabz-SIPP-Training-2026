import java.util.Scanner;

class SpaceTourist {
    static int totalReservations = 0;
    static String missionName = "Mars Explorer 2030";

    String touristName;
    int seatNumber;

    SpaceTourist(String touristName, int seatNumber) {
        this.touristName = touristName;
        this.seatNumber = seatNumber;
        totalReservations++;
    }

    SpaceTourist updateSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
        return this;
    }

    void displayDetails() {
        System.out.println("Mission: " + missionName);
        System.out.println("Tourist: " + touristName);
        System.out.println("Seat Number: " + seatNumber);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        SpaceTourist t1 = new SpaceTourist("John", 5);
        SpaceTourist t2 = new SpaceTourist("Emma", 10);

        t1.displayDetails();
        System.out.println();

        t1.updateSeatNumber(15).updateSeatNumber(20);
        System.out.println("After seat updates:");
        t1.displayDetails();

        System.out.println();
        t2.displayDetails();

        System.out.println("\nTotal Reservations: " + SpaceTourist.totalReservations);

        sc.close();
    }
}
