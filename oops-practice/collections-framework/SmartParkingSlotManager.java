import java.util.ArrayList;
import java.util.List;

public class SmartParkingSlotManager {
    private List<String> parkedVehicles;

    public SmartParkingSlotManager() {
        parkedVehicles = new ArrayList<>();
    }

    public void addVehicle(String regNumber) {
        parkedVehicles.add(regNumber);
        System.out.println("Vehicle " + regNumber + " parked successfully!");
    }

    public void removeVehicle(String regNumber) {
        if (parkedVehicles.remove(regNumber)) {
            System.out.println("Vehicle " + regNumber + " exited successfully!");
        } else {
            System.out.println("Vehicle " + regNumber + " not found!");
        }
    }

    public boolean searchVehicle(String regNumber) {
        return parkedVehicles.contains(regNumber);
    }

    public void displayVehicles() {
        System.out.println("Parked vehicles:");
        for (String vehicle : parkedVehicles) {
            System.out.println("- " + vehicle);
        }
        System.out.println("Total occupied slots: " + parkedVehicles.size());
    }

    public static void main(String[] args) {
        SmartParkingSlotManager parkingManager = new SmartParkingSlotManager();
        parkingManager.addVehicle("MH01AB1234");
        parkingManager.addVehicle("DL05CD5678");
        parkingManager.addVehicle("KA03EF9012");
        parkingManager.displayVehicles();
        boolean found = parkingManager.searchVehicle("DL05CD5678");
        System.out.println("Is DL05CD5678 parked? " + found);
        parkingManager.removeVehicle("MH01AB1234");
        parkingManager.displayVehicles();
    }
}
