import java.io.Serializable;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class EmployeeSkillAssignment implements Serializable {

    private static final long serialVersionUID = 1L;

    int employeeId;
    String name;
    String department;
    double salary;
    int skillScore;

    public EmployeeSkillAssignment(int employeeId, String name, String department, double salary, int skillScore) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.skillScore = skillScore;
    }

    public static void findTeams(int[] skillScores, int target) {
        ArrayList<ArrayList<Integer>> teams = new ArrayList<>();
        findTeamsHelper(skillScores, target, 0, new ArrayList<>(), 0, teams);

        if (teams.isEmpty()) {
            System.out.println("No teams found with the target skill score of " + target);
        } else {
            System.out.println("Possible teams with total skill score " + target + ":");
            for (int i = 0; i < teams.size(); i++) {
                ArrayList<Integer> team = teams.get(i);
                System.out.print("Team " + (i + 1) + ": Employees ");
                for (int j = 0; j < team.size(); j++) {
                    System.out.print(team.get(j));
                    if (j < team.size() - 1) {
                        System.out.print(", ");
                    }
                }
                System.out.println();
            }
        }
    }

    private static void findTeamsHelper(int[] skillScores, int target, int index, ArrayList<Integer> currentTeam, int currentSum, ArrayList<ArrayList<Integer>> teams) {
        if (currentSum == target && !currentTeam.isEmpty()) {
            teams.add(new ArrayList<>(currentTeam));
        }
        if (currentSum > target || index >= skillScores.length) {
            return;
        }

        currentTeam.add(skillScores[index]);
        findTeamsHelper(skillScores, target, index + 1, currentTeam, currentSum + skillScores[index], teams);
        currentTeam.remove(currentTeam.size() - 1);

        findTeamsHelper(skillScores, target, index + 1, currentTeam, currentSum, teams);
    }

    @Override
    public String toString() {
        return "Employee ID: " + employeeId + "\nName: " + name + "\nDepartment: " + department
                + "\nSalary: " + salary + "\nSkill Score: " + skillScore;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("How many employees do you want to enter: ");
        int numberOfEmployees = scanner.nextInt();
        scanner.nextLine();

        EmployeeSkillAssignment[] employees = new EmployeeSkillAssignment[numberOfEmployees];
        int[] skillScores = new int[numberOfEmployees];

        for (int i = 0; i < numberOfEmployees; i++) {
            System.out.println("Enter details for Employee " + (i + 1) + ":");

            System.out.print("Employee ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Name: ");
            String name = scanner.nextLine();

            System.out.print("Department: ");
            String department = scanner.nextLine();

            System.out.print("Salary: ");
            double salary = scanner.nextDouble();

            System.out.print("Skill Score: ");
            int skillScore = scanner.nextInt();
            scanner.nextLine();

            employees[i] = new EmployeeSkillAssignment(id, name, department, salary, skillScore);
            skillScores[i] = skillScore;
        }

        try {
            FileOutputStream fileOutputStream = new FileOutputStream("employees.dat");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(employees);
            objectOutputStream.close();
            System.out.println("Employee data serialized and saved to employees.dat");
        } catch (IOException e) {
            System.out.println("Error serializing data: " + e.getMessage());
        }

        try {
            FileInputStream fileInputStream = new FileInputStream("employees.dat");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            EmployeeSkillAssignment[] recoveredEmployees = (EmployeeSkillAssignment[]) objectInputStream.readObject();
            objectInputStream.close();

            System.out.println("\nRecovered Employee Information:");
            System.out.println("----------------------------------------");
            for (int i = 0; i < recoveredEmployees.length; i++) {
                System.out.println(recoveredEmployees[i]);
                System.out.println("----------------------------------------");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: employees.dat");
        } catch (Exception e) {
            System.out.println("Error reading data: " + e.getMessage());
        }

        System.out.print("\nEnter target skill score for team formation: ");
        int target = scanner.nextInt();
        findTeams(skillScores, target);

        scanner.close();
    }
}
