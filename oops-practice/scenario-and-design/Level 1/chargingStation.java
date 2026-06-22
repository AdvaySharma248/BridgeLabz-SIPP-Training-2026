import java.util.Scanner;

class ChargingStation {
    static int totalStations = 0;
    static double electricityRate = 5.0;

    String stationId;
    int unitsConsumed;

    ChargingStation(String stationId, int unitsConsumed) {
        this.stationId = stationId;
        this.unitsConsumed = unitsConsumed;
        totalStations++;
    }

    double calculateBill() {
        return unitsConsumed * electricityRate;
    }

    void displayStationDetails() {
        System.out.println("Station ID: " + stationId);
        System.out.println("Units Consumed: " + unitsConsumed);
        System.out.println("Rate per unit: " + electricityRate);
        System.out.println("Bill: " + calculateBill());
    }

    static void updateRate(double newRate) {
        electricityRate = newRate;
        System.out.println("Electricity rate updated to: " + electricityRate);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ChargingStation s1 = new ChargingStation("CS001", 100);
        ChargingStation s2 = new ChargingStation("CS002", 200);
        ChargingStation s3 = new ChargingStation("CS003", 150);
        ChargingStation s4 = new ChargingStation("CS004", 80);
        ChargingStation s5 = new ChargingStation("CS005", 250);

        System.out.println("Total stations: " + ChargingStation.totalStations);
        System.out.println("\nBills at current rate:");
        s1.displayStationDetails();
        System.out.println();
        s2.displayStationDetails();
        System.out.println();
        s3.displayStationDetails();
        System.out.println();
        s4.displayStationDetails();
        System.out.println();
        s5.displayStationDetails();

        System.out.println("\nUpdating rate...");
        ChargingStation.updateRate(7.5);

        System.out.println("\nBills after rate change:");
        s1.displayStationDetails();
        System.out.println();
        s2.displayStationDetails();

        sc.close();
    }
}
