import java.util.Scanner;

class Student {
    public int rollNumber;
    protected String name;
    private double cgpa;

    Student(int r, String n, double c) {
        rollNumber = r;
        name = n;
        cgpa = c;
    }

    public double getCgpa() {
        return cgpa;
    }

    public void setCgpa(double c) {
        cgpa = c;
    }

    void display() {
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name: " + name);
        System.out.println("CGPA: " + cgpa);
    }
}

class PostgraduateStudent extends Student {
    String specialization;

    PostgraduateStudent(int r, String n, double c, String s) {
        super(r, n, c);
        specialization = s;
    }

    void showDetails() {
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name: " + name);
        System.out.println("CGPA: " + getCgpa());
        System.out.println("Specialization: " + specialization);
    }
}

class StudentManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter roll number: ");
        int r = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter name: ");
        String n = sc.nextLine();
        System.out.print("Enter CGPA: ");
        double c = sc.nextDouble();

        Student s = new Student(r, n, c);
        s.display();

        System.out.print("Enter new CGPA: ");
        double nc = sc.nextDouble();
        s.setCgpa(nc);
        System.out.println("Updated CGPA: " + s.getCgpa());

        sc.nextLine();
        System.out.print("Enter PG specialization: ");
        String spec = sc.nextLine();

        PostgraduateStudent pg = new PostgraduateStudent(r + 1, n + " PG", c, spec);
        pg.showDetails();

        sc.close();
    }
}
