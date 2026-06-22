import java.util.Scanner;

class Drone {
    static String companyName = "SkyLogistics";

    String droneId;
    int batteryPercentage;

    Drone(String droneId, int batteryPercentage) {
        this.droneId = droneId;
        this.batteryPercentage = batteryPercentage;
    }

    void startDelivery() {
        if (batteryPercentage >= 20) {
            System.out.println("Drone " + droneId + " starting delivery...");
            batteryPercentage = batteryPercentage - 15;
            System.out.println("Delivery complete! Battery: " + batteryPercentage + "%");
        } else {
            System.out.println("Drone " + droneId + " cannot deliver. Low battery: " + batteryPercentage + "%");
        }
    }

    void displayStatus() {
        System.out.println("Company: " + companyName);
        System.out.println("Drone ID: " + droneId);
        System.out.println("Battery: " + batteryPercentage + "%");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Drone d1 = new Drone("D001", 90);
        Drone d2 = new Drone("D002", 50);
        Drone d3 = new Drone("D003", 10);

        d1.displayStatus();
        d1.startDelivery();

        System.out.println();
        d2.displayStatus();
        d2.startDelivery();

        System.out.println();
        d3.displayStatus();
        d3.startDelivery();

        System.out.println("\nAll drones belong to: " + Drone.companyName);

        sc.close();
    }
}
