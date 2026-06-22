import java.util.Scanner;
import java.util.HashMap;

class UndergroundSystem {
    HashMap<Integer, String> checkIns;
    HashMap<Integer, Integer> checkInTimes;
    HashMap<String, Integer> routeTotalTime;
    HashMap<String, Integer> routeCount;

    UndergroundSystem() {
        checkIns = new HashMap<>();
        checkInTimes = new HashMap<>();
        routeTotalTime = new HashMap<>();
        routeCount = new HashMap<>();
    }

    void checkIn(int id, String stationName, int t) {
        checkIns.put(id, stationName);
        checkInTimes.put(id, t);
    }

    void checkOut(int id, String stationName, int t) {
        String startStation = checkIns.get(id);
        int startTime = checkInTimes.get(id);
        String route = startStation + "-" + stationName;
        int travelTime = t - startTime;

        routeTotalTime.put(route, routeTotalTime.getOrDefault(route, 0) + travelTime);
        routeCount.put(route, routeCount.getOrDefault(route, 0) + 1);
    }

    double getAverageTime(String startStation, String endStation) {
        String route = startStation + "-" + endStation;
        int total = routeTotalTime.getOrDefault(route, 0);
        int count = routeCount.getOrDefault(route, 0);
        if (count == 0) return 0;
        return (double) total / count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        UndergroundSystem us = new UndergroundSystem();

        us.checkIn(1, "StationA", 5);
        us.checkIn(2, "StationA", 10);
        us.checkIn(3, "StationB", 15);

        us.checkOut(1, "StationB", 20);
        us.checkOut(2, "StationB", 30);
        us.checkOut(3, "StationC", 40);

        System.out.println("Avg A to B: " + us.getAverageTime("StationA", "StationB"));
        System.out.println("Avg B to C: " + us.getAverageTime("StationB", "StationC"));

        us.checkIn(4, "StationA", 50);
        us.checkOut(4, "StationB", 70);

        System.out.println("Avg A to B after new trip: " + us.getAverageTime("StationA", "StationB"));

        sc.close();
    }
}
