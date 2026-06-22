import java.util.Scanner;

public class Student {
    String name;
    int rollNumber;
    double marks;

    String calculateGrade() {
        if (marks >= 90) {
            return "A";
        } else if (marks >= 80) {
            return "B";
        } else if (marks >= 70) {
            return "C";
        } else if (marks >= 60) {
            return "D";
        } else {
            return "F";
        }
    }

    void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Marks: " + marks);
        System.out.println("Grade: " + calculateGrade());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter student name: ");
        String n = sc.nextLine();

        System.out.print("Enter roll number: ");
        int r = sc.nextInt();

        System.out.print("Enter marks: ");
        double m = sc.nextDouble();

        Student s = new Student();
        s.name = n;
        s.rollNumber = r;
        s.marks = m;

        s.displayDetails();

        sc.close();
    }
}
