abstract class Employee {
    private int employeeId;
    private String employeeName;

    int getEmployeeId() {
        return employeeId;
    }

    void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    String getEmployeeName() {
        return employeeName;
    }

    void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    abstract double calculateSalary();

    void displayEmployeeInfo() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Employee Name: " + employeeName);
    }
}

class FullTimeEmployee extends Employee {
    private double monthlySalary;

    double getMonthlySalary() {
        return monthlySalary;
    }

    void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    double calculateSalary() {
        return monthlySalary;
    }
}

class PartTimeEmployee extends Employee {
    private int hoursWorked;
    private double hourlyRate;

    int getHoursWorked() {
        return hoursWorked;
    }

    void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    double getHourlyRate() {
        return hourlyRate;
    }

    void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    double calculateSalary() {
        return hoursWorked * hourlyRate;
    }
}

public class EmployeePayrollSystem {
    public static void main(String[] args) {
        FullTimeEmployee fullTimeEmp = new FullTimeEmployee();
        fullTimeEmp.setEmployeeId(101);
        fullTimeEmp.setEmployeeName("John Doe");
        fullTimeEmp.setMonthlySalary(50000);

        PartTimeEmployee partTimeEmp = new PartTimeEmployee();
        partTimeEmp.setEmployeeId(102);
        partTimeEmp.setEmployeeName("Jane Smith");
        partTimeEmp.setHoursWorked(40);
        partTimeEmp.setHourlyRate(200);

        System.out.println("Full Time Employee:");
        fullTimeEmp.displayEmployeeInfo();
        System.out.println("Salary: " + fullTimeEmp.calculateSalary());
        System.out.println();

        System.out.println("Part Time Employee:");
        partTimeEmp.displayEmployeeInfo();
        System.out.println("Salary: " + partTimeEmp.calculateSalary());
    }
}
