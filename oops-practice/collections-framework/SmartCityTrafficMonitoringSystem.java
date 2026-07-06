import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class SmartCityTrafficMonitoringSystem {
    private Map<String, Integer> trafficMap;

    public SmartCityTrafficMonitoringSystem() {
        trafficMap = new HashMap<>();
    }

    public void updateTraffic(String roadName, int count) {
        trafficMap.put(roadName, trafficMap.getOrDefault(roadName, 0) + count);
        System.out.println("Traffic updated for " + roadName + ": +" + count);
    }

    public void displaySortedRoads() {
        TreeMap<String, Integer> sortedMap = new TreeMap<>(trafficMap);
        System.out.println("\nRoads sorted by name:");
        for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
            System.out.println("- " + entry.getKey() + ": " + entry.getValue() + " vehicles");
        }
    }

    public void findBusiestRoad() {
        if (trafficMap.isEmpty()) {
            System.out.println("No roads monitored!");
            return;
        }
        String busiestRoad = null;
        int maxVehicles = -1;
        for (Map.Entry<String, Integer> entry : trafficMap.entrySet()) {
            if (entry.getValue() > maxVehicles) {
                maxVehicles = entry.getValue();
                busiestRoad = entry.getKey();
            }
        }
        System.out.println("\nBusiest road: " + busiestRoad + " with " + maxVehicles + " vehicles");
    }

    public void generateReport() {
        System.out.println("\n=== Traffic Analysis Report ===");
        displaySortedRoads();
        findBusiestRoad();
        System.out.println("Total roads monitored: " + trafficMap.size());
    }

    public static void main(String[] args) {
        SmartCityTrafficMonitoringSystem trafficSystem = new SmartCityTrafficMonitoringSystem();
        trafficSystem.updateTraffic("MG Road", 50);
        trafficSystem.updateTraffic("Brigade Road", 30);
        trafficSystem.updateTraffic("MG Road", 20);
        trafficSystem.updateTraffic("Residency Road", 40);
        trafficSystem.generateReport();
    }
}
