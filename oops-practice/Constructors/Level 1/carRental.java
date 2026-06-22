import java.util.Scanner;

class CarRental {
    String customerName;
    String carModel;
    int rentalDays;
    double costPerDay;

    CarRental() {
        customerName = "Customer";
        carModel = "Sedan";
        rentalDays = 1;
        costPerDay = 500.0;
    }

    CarRental(String c, String m, int d, double cpd) {
        customerName = c;
        carModel = m;
        rentalDays = d;
        costPerDay = cpd;
    }

    double calculateTotalCost() {
        return rentalDays * costPerDay;
    }

    void display() {
        System.out.println("Customer: " + customerName);
        System.out.println("Car Model: " + carModel);
        System.out.println("Rental Days: " + rentalDays);
        System.out.println("Cost Per Day: " + costPerDay);
        System.out.println("Total Cost: " + calculateTotalCost());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter customer name: ");
        String c = sc.nextLine();
        System.out.print("Enter car model: ");
        String m = sc.nextLine();
        System.out.print("Enter rental days: ");
        int d = sc.nextInt();
        System.out.print("Enter cost per day: ");
        double cpd = sc.nextDouble();

        CarRental rental = new CarRental(c, m, d, cpd);
        rental.display();

        sc.close();
    }
}
