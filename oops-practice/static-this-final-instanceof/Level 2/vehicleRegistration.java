import java.util.Scanner;

class Vehicle {
    static double registrationFee = 1000.0;

    String ownerName;
    String vehicleType;
    final String registrationNumber;

    Vehicle(String ownerName, String vehicleType, String registrationNumber) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
        this.registrationNumber = registrationNumber;
    }

    static void updateRegistrationFee(double fee) {
        registrationFee = fee;
        System.out.println("Registration fee updated to: " + registrationFee);
    }

    void displayDetails() {
        System.out.println("Owner: " + ownerName);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Registration Number: " + registrationNumber);
        System.out.println("Registration Fee: " + registrationFee);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter owner name: ");
        String o = sc.nextLine();
        System.out.print("Enter vehicle type: ");
        String v = sc.nextLine();
        System.out.print("Enter registration number: ");
        String r = sc.nextLine();

        Vehicle veh1 = new Vehicle(o, v, r);

        if (veh1 instanceof Vehicle) {
            veh1.displayDetails();
        }

        System.out.print("Enter new registration fee: ");
        double fee = sc.nextDouble();
        Vehicle.updateRegistrationFee(fee);

        sc.nextLine();
        System.out.print("Enter owner name: ");
        String o2 = sc.nextLine();
        System.out.print("Enter vehicle type: ");
        String v2 = sc.nextLine();
        System.out.print("Enter registration number: ");
        String r2 = sc.nextLine();

        Vehicle veh2 = new Vehicle(o2, v2, r2);

        if (veh2 instanceof Vehicle) {
            veh2.displayDetails();
        }

        sc.close();
    }
}
