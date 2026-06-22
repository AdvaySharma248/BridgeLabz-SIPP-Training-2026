import java.util.Scanner;

class Vehicle {
    String ownerName;
    String vehicleType;
    static double registrationFee = 500.0;

    Vehicle(String o, String v) {
        ownerName = o;
        vehicleType = v;
    }

    void displayVehicleDetails() {
        System.out.println("Owner: " + ownerName);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Registration Fee: " + registrationFee);
    }

    static void updateRegistrationFee(double fee) {
        registrationFee = fee;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter owner name: ");
        String o1 = sc.nextLine();
        System.out.print("Enter vehicle type: ");
        String v1 = sc.nextLine();

        Vehicle veh1 = new Vehicle(o1, v1);
        veh1.displayVehicleDetails();

        System.out.print("Enter new registration fee: ");
        double fee = sc.nextDouble();
        Vehicle.updateRegistrationFee(fee);

        System.out.print("Enter owner name: ");
        sc.nextLine();
        String o2 = sc.nextLine();
        System.out.print("Enter vehicle type: ");
        String v2 = sc.nextLine();

        Vehicle veh2 = new Vehicle(o2, v2);
        veh2.displayVehicleDetails();

        sc.close();
    }
}
