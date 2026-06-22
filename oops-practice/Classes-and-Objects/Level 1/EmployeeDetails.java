import java.util.Scanner;

public class EmployeeDetails {
    String name;
    int id;
    double salary;

    void displayDetails() {
        System.out.println("Employee Name: " + name);
        System.out.println("Employee ID: " + id);
        System.out.println("Employee Salary: " + salary);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter employee name: ");
        String name = sc.nextLine();

        System.out.print("Enter employee id: ");
        int id = sc.nextInt();

        System.out.print("Enter employee salary: ");
        double salary = sc.nextDouble();

        EmployeeDetails emp = new EmployeeDetails();
        emp.name = name;
        emp.id = id;
        emp.salary = salary;

        emp.displayDetails();

        sc.close();
    }
}
