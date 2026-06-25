package polymorphism;

class RescueTeam {
    String teamId;
    String location;

    public RescueTeam(String teamId, String location) {
        this.teamId = teamId;
        this.location = location;
    }

    public void performDuty() {
        System.out.println("Team " + teamId + " is on standby at " + location);
    }

    public void display() {
        System.out.println("Team ID: " + teamId + " | Location: " + location);
    }
}

class MedicalTeam extends RescueTeam {
    public MedicalTeam(String teamId, String location) {
        super(teamId, location);
    }

    @Override
    public void performDuty() {
        System.out.println("Medical Team " + teamId + " at " + location + ": Providing first aid and medical care.");
    }
}

class FireRescueTeam extends RescueTeam {
    public FireRescueTeam(String teamId, String location) {
        super(teamId, location);
    }

    @Override
    public void performDuty() {
        System.out.println("Fire Rescue Team " + teamId + " at " + location + ": Extinguishing fires and rescuing trapped people.");
    }
}

class FoodSupplyTeam extends RescueTeam {
    public FoodSupplyTeam(String teamId, String location) {
        super(teamId, location);
    }

    @Override
    public void performDuty() {
        System.out.println("Food Supply Team " + teamId + " at " + location + ": Distributing food and water packets.");
    }
}

public class RescueManagement {

    // Requirement 2: findTeamByLocation
    public static void findTeamByLocation(RescueTeam[] teams, String loc) {
        System.out.println("--- Searching for teams in " + loc + " ---");
        boolean found = false;
        for (RescueTeam t : teams) {
            if (t.location.equalsIgnoreCase(loc)) {
                t.display();
                found = true;
            }
        }
        if (!found) System.out.println("No teams found in " + loc);
    }

    // Requirement 2: displayTeamsByPrefix
    public static void displayTeamsByPrefix(RescueTeam[] teams, String prefix) {
        System.out.println("--- Teams starting with ID prefix '" + prefix + "' ---");
        boolean found = false;
        for (RescueTeam t : teams) {
            if (t.teamId.startsWith(prefix)) {
                t.display();
                found = true;
            }
        }
        if (!found) System.out.println("No teams found with prefix " + prefix);
    }

    public static void main(String[] args) {
        // Requirement 1: Store all teams in a RescueTeam[] array
        RescueTeam[] deployedTeams = new RescueTeam[5];
        deployedTeams[0] = new MedicalTeam("MED-01", "Zone A");
        deployedTeams[1] = new FireRescueTeam("FIRE-01", "Zone B");
        deployedTeams[2] = new FoodSupplyTeam("FOOD-01", "Zone A");
        deployedTeams[3] = new MedicalTeam("MED-02", "Zone C");
        deployedTeams[4] = new FireRescueTeam("FIRE-02", "Zone A");

        // Requirement 3: Use polymorphism to perform duties
        System.out.println("--- Deployment Duties ---");
        for (RescueTeam t : deployedTeams) {
            t.performDuty();
        }

        // Search by location
        System.out.println();
        findTeamByLocation(deployedTeams, "Zone A");

        // Display by prefix
        System.out.println();
        displayTeamsByPrefix(deployedTeams, "MED");

        // Requirement 4: Count teams deployed in each category
        int medicalCount = 0, fireCount = 0, foodCount = 0;
        for (RescueTeam t : deployedTeams) {
            if (t instanceof MedicalTeam) medicalCount++;
            else if (t instanceof FireRescueTeam) fireCount++;
            else if (t instanceof FoodSupplyTeam) foodCount++;
        }

        System.out.println("\n--- Deployment Statistics ---");
        System.out.println("Medical Teams: " + medicalCount);
        System.out.println("Fire Rescue Teams: " + fireCount);
        System.out.println("Food Supply Teams: " + foodCount);

        // Requirement 5: Display the team category having the maximum deployments
        String maxCategory = "Medical";
        int maxCount = medicalCount;

        if (fireCount > maxCount) {
            maxCategory = "Fire Rescue";
            maxCount = fireCount;
        }
        if (foodCount > maxCount) {
            maxCategory = "Food Supply";
            maxCount = foodCount;
        }

        System.out.println("\nCategory with Maximum Deployments: " + maxCategory + " (" + maxCount + " teams)");
    }
}
