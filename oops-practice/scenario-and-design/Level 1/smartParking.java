import java.util.Scanner;

class Vehicle {
    String vehicleNumber;
    String ownerName;
    String vehicleType;

    Vehicle(String vehicleNumber, String ownerName, String vehicleType) {
        this.vehicleNumber = vehicleNumber;
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    void display() {
        System.out.println(vehicleNumber + " | " + ownerName + " | " + vehicleType);
    }
}

class SmartParking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Vehicle[] vehicles = new Vehicle[10];
        vehicles[0] = new Vehicle("KA01AB1234", "Rahul", "Car");
        vehicles[1] = new Vehicle("KA02CD5678", "Priya", "Bike");
        vehicles[2] = new Vehicle("KA03EF9012", "Amit", "Car");
        vehicles[3] = new Vehicle("KA04GH3456", "Sneha", "Bike");
        vehicles[4] = new Vehicle("KA05IJ7890", "Vikram", "Car");
        vehicles[5] = new Vehicle("KA06KL1234", "Anita", "Car");
        vehicles[6] = new Vehicle("KA07MN5678", "Ravi", "Bike");
        vehicles[7] = new Vehicle("KA08OP9012", "Deepa", "Car");
        vehicles[8] = new Vehicle("KA09QR3456", "Kiran", "Bike");
        vehicles[9] = new Vehicle("KA10ST7890", "Meena", "Car");

        System.out.println("All Cars:");
        displayCars(vehicles);

        System.out.println("\nAll Bikes:");
        displayBikes(vehicles);

        sc.close();
    }

    static void displayCars(Vehicle[] vehicles) {
        for (int i = 0; i < vehicles.length; i++) {
            if (vehicles[i].vehicleType.equalsIgnoreCase("Car")) {
                vehicles[i].display();
            }
        }
    }

    static void displayBikes(Vehicle[] vehicles) {
        for (int i = 0; i < vehicles.length; i++) {
            if (vehicles[i].vehicleType.equalsIgnoreCase("Bike")) {
                vehicles[i].display();
            }
        }
    }
}
