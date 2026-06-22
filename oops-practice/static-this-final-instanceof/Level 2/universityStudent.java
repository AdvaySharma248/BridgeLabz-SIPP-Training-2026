import java.util.Scanner;

class Student {
    static String universityName = "State University";
    static int totalStudents = 0;

    String name;
    final int rollNumber;
    String grade;

    Student(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
        totalStudents++;
    }

    static void displayTotalStudents() {
        System.out.println("Total Students: " + totalStudents);
    }

    void displayDetails() {
        System.out.println("University: " + universityName);
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Grade: " + grade);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter name: ");
        String n = sc.nextLine();
        System.out.print("Enter roll number: ");
        int r = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter grade: ");
        String g = sc.nextLine();

        Student s1 = new Student(n, r, g);

        if (s1 instanceof Student) {
            s1.displayDetails();
        }

        System.out.print("Enter name: ");
        String n2 = sc.nextLine();
        System.out.print("Enter roll number: ");
        int r2 = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter grade: ");
        String g2 = sc.nextLine();

        Student s2 = new Student(n2, r2, g2);

        if (s2 instanceof Student) {
            s2.displayDetails();
        }

        Student.displayTotalStudents();

        sc.close();
    }
}
