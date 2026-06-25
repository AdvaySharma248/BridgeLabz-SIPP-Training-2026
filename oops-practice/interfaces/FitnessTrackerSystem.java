package interfaces;

interface Trackable {
    void logActivity(String activity);
    
    // Requirement: Add a default method resetData() to Trackable
    default void resetData() {
        System.out.println("All tracking data has been reset.");
    }
}

interface Reportable {
    void generateReport();
}

interface Notifiable {
    void sendAlert(String message);
}

// Requirement: Class FitnessDevice implements all three
class FitnessDevice implements Trackable, Reportable, Notifiable {
    String deviceName;

    public FitnessDevice(String name) {
        this.deviceName = name;
    }

    @Override
    public void logActivity(String activity) {
        System.out.println(deviceName + " logged activity: " + activity);
    }

    @Override
    public void generateReport() {
        System.out.println("Generating health report for " + deviceName + "...");
        System.out.println("Report: You walked 10,000 steps today!");
    }

    @Override
    public void sendAlert(String message) {
        System.out.println("ALERT from " + deviceName + ": " + message);
    }
}

public class FitnessTrackerSystem {
    public static void main(String[] args) {
        FitnessDevice myWatch = new FitnessDevice("SmartWatch X");

        System.out.println("--- Fitness Device Operations ---");
        // Using methods from multiple interfaces
        myWatch.logActivity("Morning Run");
        myWatch.generateReport();
        myWatch.sendAlert("Low Battery!");

        // Using default method from Trackable
        System.out.println("\nResetting data...");
        myWatch.resetData();

        System.out.println("\n--- Multiple Interface Implementation ---");
        System.out.println("Java allows a class to implement multiple interfaces,");
        System.out.println("which helps in achieving multiple inheritance of behavior.");
        System.out.println("FitnessDevice is Trackable: " + (myWatch instanceof Trackable));
        System.out.println("FitnessDevice is Reportable: " + (myWatch instanceof Reportable));
        System.out.println("FitnessDevice is Notifiable: " + (myWatch instanceof Notifiable));
    }
}
