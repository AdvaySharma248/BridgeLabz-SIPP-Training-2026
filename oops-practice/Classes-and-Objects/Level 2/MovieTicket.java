import java.util.Scanner;

public class MovieTicket {
    String movieName;
    String seatNumber;
    double price;

    void bookTicket(String seat, double ticketPrice) {
        this.seatNumber = seat;
        this.price = ticketPrice;
        System.out.println("Ticket booked successfully!");
    }

    void displayTicketDetails() {
        System.out.println("Movie: " + movieName);
        System.out.println("Seat Number: " + seatNumber);
        System.out.println("Price: " + price);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter movie name: ");
        String movie = sc.nextLine();

        System.out.print("Enter seat number: ");
        String seat = sc.nextLine();

        System.out.print("Enter ticket price: ");
        double p = sc.nextDouble();

        MovieTicket ticket = new MovieTicket();
        ticket.movieName = movie;
        ticket.bookTicket(seat, p);

        ticket.displayTicketDetails();

        sc.close();
    }
}
