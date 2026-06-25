package interfaces;

interface HeartRateMonitor {
    void showHeartRate(int rate);

    default void displayHealthTips() {
        System.out.println("Heart Health Tip: Maintain a resting heart rate between 60-100 bpm.");
    }
}

interface TemperatureMonitor {
    void showTemperature(double temp);

    default void displayHealthTips() {
        System.out.println("Temperature Tip: Normal body temperature is around 98.6°F (37°C).");
    }

    // Requirement: static method isPatientIdValid
    static boolean isPatientIdValid(String patientId) {
        // Simple beginner level check: ID should start with "PAT" and have 3 digits
        return patientId != null && patientId.startsWith("PAT") && patientId.length() == 6;
    }
}

// Requirement: class HealthMonitoringSystem implementing both interfaces
class HealthMonitoringSystem implements HeartRateMonitor, TemperatureMonitor {
    
    @Override
    public void showHeartRate(int rate) {
        System.out.println("Heart Rate Reading: " + rate + " BPM");
        if (rate > 100) System.out.println("Warning: High Heart Rate!");
    }

    @Override
    public void showTemperature(double temp) {
        System.out.println("Temperature Reading: " + temp + "°F");
        if (temp > 100.4) System.out.println("Warning: Fever Detected!");
    }

    // Requirement: resolve default method conflicts
    @Override
    public void displayHealthTips() {
        System.out.println("--- General Health Tips ---");
        HeartRateMonitor.super.displayHealthTips();
        TemperatureMonitor.super.displayHealthTips();
    }

    // Requirement: generate a final health report for all patients
    public void generateReport(String name, String id, int hr, double temp) {
        System.out.println("--- Final Health Report for " + name + " (" + id + ") ---");
        showHeartRate(hr);
        showTemperature(temp);
        System.out.println("Status: Processed successfully.");
        System.out.println("--------------------------------------------------");
    }
}

public class HealthMonitoringMain {
    public static void main(String[] args) {
        // Requirement: Store patient names and IDs in arrays
        String[] patientNames = {"Alice", "Bob", "Charlie", "David"};
        String[] patientIds = {"PAT101", "PAT102", "INVALID", "PAT104"};
        int[] heartRates = {72, 105, 80, 65};
        double[] temperatures = {98.6, 101.2, 99.0, 97.5};

        HealthMonitoringSystem system = new HealthMonitoringSystem();
        system.displayHealthTips();
        System.out.println();

        for (int i = 0; i < patientNames.length; i++) {
            // Requirement: validate patient IDs
            if (TemperatureMonitor.isPatientIdValid(patientIds[i])) {
                system.generateReport(patientNames[i], patientIds[i], heartRates[i], temperatures[i]);
            } else {
                System.out.println("Error: Invalid Patient ID (" + patientIds[i] + ") for " + patientNames[i]);
                System.out.println("--------------------------------------------------");
            }
        }
    }
}
