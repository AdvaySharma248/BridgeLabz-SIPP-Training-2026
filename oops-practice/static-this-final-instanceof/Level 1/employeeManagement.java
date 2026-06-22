import java.util.Scanner;

class Employee {
    static String companyName = "TechCorp";
    static int totalEmployees = 0;

    String name;
    final int id;
    String designation;

    Employee(String name, int id, String designation) {
        this.name = name;
        this.id = id;
        this.designation = designation;
        totalEmployees++;
    }

    static void displayTotalEmployees() {
        System.out.println("Total Employees: " + totalEmployees);
    }

    void displayDetails() {
        System.out.println("Company: " + companyName);
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Designation: " + designation);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter name: ");
        String n = sc.nextLine();
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter designation: ");
        String d = sc.nextLine();

        Employee e1 = new Employee(n, id, d);

        if (e1 instanceof Employee) {
            e1.displayDetails();
        }

        System.out.print("Enter name: ");
        String n2 = sc.nextLine();
        System.out.print("Enter ID: ");
        int id2 = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter designation: ");
        String d2 = sc.nextLine();

        Employee e2 = new Employee(n2, id2, d2);

        if (e2 instanceof Employee) {
            e2.displayDetails();
        }

        Employee.displayTotalEmployees();

        sc.close();
    }
}
