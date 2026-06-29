abstract class Vehicle {
    private String vehicleNumber;
    private String vehicleType;

    String getVehicleNumber() {
        return vehicleNumber;
    }

    void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    String getVehicleType() {
        return vehicleType;
    }

    void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    abstract double calculateRentalCost(int days);
}

class Car extends Vehicle {
    private double dailyRate;

    double getDailyRate() {
        return dailyRate;
    }

    void setDailyRate(double dailyRate) {
        this.dailyRate = dailyRate;
    }

    double calculateRentalCost(int days) {
        return days * dailyRate;
    }
}

class Bike extends Vehicle {
    private double dailyRate;

    double getDailyRate() {
        return dailyRate;
    }

    void setDailyRate(double dailyRate) {
        this.dailyRate = dailyRate;
    }

    double calculateRentalCost(int days) {
        return days * dailyRate;
    }
}

class Truck extends Vehicle {
    private double dailyRate;
    private double loadingCharge;

    double getDailyRate() {
        return dailyRate;
    }

    void setDailyRate(double dailyRate) {
        this.dailyRate = dailyRate;
    }

    double getLoadingCharge() {
        return loadingCharge;
    }

    void setLoadingCharge(double loadingCharge) {
        this.loadingCharge = loadingCharge;
    }

    double calculateRentalCost(int days) {
        return (days * dailyRate) + loadingCharge;
    }
}

public class VehicleRentalSystem {
    public static void main(String[] args) {
        Car car = new Car();
        car.setVehicleNumber("MH01AB1234");
        car.setVehicleType("Car");
        car.setDailyRate(1000);

        Bike bike = new Bike();
        bike.setVehicleNumber("MH02CD5678");
        bike.setVehicleType("Bike");
        bike.setDailyRate(300);

        Truck truck = new Truck();
        truck.setVehicleNumber("MH03EF9012");
        truck.setVehicleType("Truck");
        truck.setDailyRate(2000);
        truck.setLoadingCharge(500);

        int days = 5;

        System.out.println("Car Details:");
        System.out.println("Vehicle Number: " + car.getVehicleNumber());
        System.out.println("Vehicle Type: " + car.getVehicleType());
        System.out.println("Rental Cost for " + days + " days: " + car.calculateRentalCost(days));
        System.out.println();

        System.out.println("Bike Details:");
        System.out.println("Vehicle Number: " + bike.getVehicleNumber());
        System.out.println("Vehicle Type: " + bike.getVehicleType());
        System.out.println("Rental Cost for " + days + " days: " + bike.calculateRentalCost(days));
        System.out.println();

        System.out.println("Truck Details:");
        System.out.println("Vehicle Number: " + truck.getVehicleNumber());
        System.out.println("Vehicle Type: " + truck.getVehicleType());
        System.out.println("Rental Cost for " + days + " days: " + truck.calculateRentalCost(days));
    }
}
