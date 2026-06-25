package polymorphism;

class TollVehicle {
    String vehicleNumber;
    String ownerName;

    public TollVehicle(String vehicleNumber, String ownerName) {
        this.vehicleNumber = vehicleNumber;
        this.ownerName = ownerName;
    }

    public double calculateToll() {
        return 0.0;
    }

    public void display() {
        System.out.println("Vehicle No: " + vehicleNumber + " | Owner: " + ownerName);
    }
}

class CarToll extends TollVehicle {
    public CarToll(String vehicleNumber, String ownerName) {
        super(vehicleNumber, ownerName);
    }

    @Override
    public double calculateToll() {
        return 50.0;
    }
}

class BusToll extends TollVehicle {
    public BusToll(String vehicleNumber, String ownerName) {
        super(vehicleNumber, ownerName);
    }

    @Override
    public double calculateToll() {
        return 100.0;
    }
}

class TruckToll extends TollVehicle {
    public TruckToll(String vehicleNumber, String ownerName) {
        super(vehicleNumber, ownerName);
    }

    @Override
    public double calculateToll() {
        return 150.0;
    }
}

public class TollManagement {
    
    // Requirement 2: calculateTotalRevenue
    public static double calculateTotalRevenue(TollVehicle[] vehicles) {
        double total = 0;
        for (TollVehicle v : vehicles) {
            total += v.calculateToll();
        }
        return total;
    }

    // Requirement 2: searchVehicle
    public static void searchVehicle(TollVehicle[] vehicles, String number) {
        boolean found = false;
        for (TollVehicle v : vehicles) {
            if (v.vehicleNumber.equalsIgnoreCase(number)) {
                System.out.print("Vehicle Found: ");
                v.display();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Vehicle with number " + number + " not found.");
        }
    }

    public static void main(String[] args) {
        // Requirement 1: Store all vehicles in a Vehicle[] array
        TollVehicle[] plazaVehicles = new TollVehicle[5];
        plazaVehicles[0] = new CarToll("MH12-1234", "John");
        plazaVehicles[1] = new BusToll("KA01-5555", "SRS Travels");
        plazaVehicles[2] = new TruckToll("DL05-9999", "Logistic Corp");
        plazaVehicles[3] = new CarToll("HR26-4321", "Alice");
        plazaVehicles[4] = new TruckToll("UP32-7777", "Build-It");

        // Requirement 3: Use polymorphism to calculate tolls
        System.out.println("--- Toll Collection Details ---");
        for (TollVehicle v : plazaVehicles) {
            System.out.println(v.vehicleNumber + " paid: $" + v.calculateToll());
        }

        // Requirement 2 & 3: Total revenue
        System.out.println("\nTotal Revenue: $" + calculateTotalRevenue(plazaVehicles));

        // Requirement 2: Search vehicle
        System.out.println("\n--- Searching for Vehicle MH12-1234 ---");
        searchVehicle(plazaVehicles, "MH12-1234");

        // Requirement 4: Display the vehicle that paid the highest toll
        TollVehicle maxTollVehicle = plazaVehicles[0];
        for (TollVehicle v : plazaVehicles) {
            if (v.calculateToll() > maxTollVehicle.calculateToll()) {
                maxTollVehicle = v;
            }
        }
        System.out.println("\n--- Highest Toll Paid By ---");
        maxTollVehicle.display();
        System.out.println("Toll Amount: $" + maxTollVehicle.calculateToll());

        // Requirement 5: Count total vehicles by type
        int carCount = 0, busCount = 0, truckCount = 0;
        for (TollVehicle v : plazaVehicles) {
            if (v instanceof CarToll) carCount++;
            else if (v instanceof BusToll) busCount++;
            else if (v instanceof TruckToll) truckCount++;
        }
        System.out.println("\n--- Vehicle Count Summary ---");
        System.out.println("Cars: " + carCount);
        System.out.println("Buses: " + busCount);
        System.out.println("Trucks: " + truckCount);
    }
}
