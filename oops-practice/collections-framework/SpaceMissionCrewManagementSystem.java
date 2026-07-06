import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Astronaut {
    int astronautId;
    String name;
    String specialization;

    public Astronaut(int astronautId, String name, String specialization) {
        this.astronautId = astronautId;
        this.name = name;
        this.specialization = specialization;
    }

    public String toString() {
        return "ID: " + astronautId + ", Name: " + name + ", Specialization: " + specialization;
    }
}

public class SpaceMissionCrewManagementSystem {
    private Map<String, List<Astronaut>> missionCrewMap;
    private Map<String, Set<String>> missionAstronautIds;

    public SpaceMissionCrewManagementSystem() {
        missionCrewMap = new HashMap<>();
        missionAstronautIds = new HashMap<>();
    }

    public void addMission(String missionName) {
        if (!missionCrewMap.containsKey(missionName)) {
            missionCrewMap.put(missionName, new ArrayList<>());
            missionAstronautIds.put(missionName, new HashSet<>());
            System.out.println("Mission " + missionName + " added successfully!");
        } else {
            System.out.println("Mission " + missionName + " already exists!");
        }
    }

    public void assignAstronaut(String missionName, Astronaut astronaut) {
        if (!missionCrewMap.containsKey(missionName)) {
            System.out.println("Mission " + missionName + " not found!");
            return;
        }
        Set<String> astronautIds = missionAstronautIds.get(missionName);
        String idStr = String.valueOf(astronaut.astronautId);
        if (astronautIds.contains(idStr)) {
            System.out.println("Astronaut " + astronaut.name + " is already assigned to " + missionName);
            return;
        }
        missionCrewMap.get(missionName).add(astronaut);
        astronautIds.add(idStr);
        System.out.println("Astronaut " + astronaut.name + " assigned to " + missionName + " successfully!");
    }

    public void displayMissions() {
        for (Map.Entry<String, List<Astronaut>> entry : missionCrewMap.entrySet()) {
            String missionName = entry.getKey();
            List<Astronaut> crew = entry.getValue();
            System.out.println("\nMission: " + missionName);
            System.out.println("Crew members:");
            for (Astronaut astronaut : crew) {
                System.out.println("- " + astronaut);
            }
            System.out.println("Total crew size: " + crew.size());
        }
    }

    public static void main(String[] args) {
        SpaceMissionCrewManagementSystem system = new SpaceMissionCrewManagementSystem();
        system.addMission("Apollo 11");
        system.addMission("Mars Rover");
        Astronaut a1 = new Astronaut(1, "Neil Armstrong", "Commander");
        Astronaut a2 = new Astronaut(2, "Buzz Aldrin", "Lunar Module Pilot");
        Astronaut a3 = new Astronaut(3, "Michael Collins", "Command Module Pilot");
        system.assignAstronaut("Apollo 11", a1);
        system.assignAstronaut("Apollo 11", a2);
        system.assignAstronaut("Apollo 11", a1);
        system.assignAstronaut("Mars Rover", a3);
        system.displayMissions();
    }
}
