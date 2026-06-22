import java.util.Scanner;

class Employee {
    public int employeeID;
    protected String department;
    private double salary;

    Employee(int id, String d, double s) {
        employeeID = id;
        department = d;
        salary = s;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double s) {
        salary = s;
    }

    void display() {
        System.out.println("Employee ID: " + employeeID);
        System.out.println("Department: " + department);
        System.out.println("Salary: " + salary);
    }
}

class Manager extends Employee {
    String teamName;

    Manager(int id, String d, double s, String t) {
        super(id, d, s);
        teamName = t;
    }

    void showManagerDetails() {
        System.out.println("Employee ID: " + employeeID);
        System.out.println("Department: " + department);
        System.out.println("Salary: " + getSalary());
        System.out.println("Team: " + teamName);
    }
}

class EmployeeRecords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter employee ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter department: ");
        String d = sc.nextLine();
        System.out.print("Enter salary: ");
        double s = sc.nextDouble();

        Employee emp = new Employee(id, d, s);
        emp.display();

        System.out.print("Enter new salary: ");
        double ns = sc.nextDouble();
        emp.setSalary(ns);
        System.out.println("Updated Salary: " + emp.getSalary());

        sc.nextLine();
        System.out.print("Enter manager team name: ");
        String team = sc.nextLine();

        Manager mgr = new Manager(id + 100, d, s, team);
        mgr.showManagerDetails();

        sc.close();
    }
}
