import java.util.Scanner;

public class MovieSeatReservation {

    static int seats[] = {101, 102, 103, 104, 105};

    static int getSeat(int index) {
        try {
            return seats[index];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid seat position: " + index + ". Valid positions are 0 to " + (seats.length - 1));
            return -1;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter seat position: ");
        int index = sc.nextInt();
        int seatNumber = getSeat(index);
        if (seatNumber != -1) {
            System.out.println("Your seat number is: " + seatNumber);
        } else {
            System.out.println("Seat booking failed.");
        }
        sc.close();
    }
}
