import java.util.Scanner;

class Course {
    String courseName;
    int duration;
    double fee;
    static String instituteName = "Tech Institute";

    Course(String c, int d, double f) {
        courseName = c;
        duration = d;
        fee = f;
    }

    void displayCourseDetails() {
        System.out.println("Institute: " + instituteName);
        System.out.println("Course: " + courseName);
        System.out.println("Duration: " + duration + " months");
        System.out.println("Fee: " + fee);
    }

    static void updateInstituteName(String name) {
        instituteName = name;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter course 1 name: ");
        String c1 = sc.nextLine();
        System.out.print("Enter duration (months): ");
        int d1 = sc.nextInt();
        System.out.print("Enter fee: ");
        double f1 = sc.nextDouble();
        sc.nextLine();

        Course course1 = new Course(c1, d1, f1);
        course1.displayCourseDetails();

        System.out.print("Enter new institute name: ");
        String newName = sc.nextLine();
        Course.updateInstituteName(newName);

        System.out.print("Enter course 2 name: ");
        String c2 = sc.nextLine();
        System.out.print("Enter duration (months): ");
        int d2 = sc.nextInt();
        System.out.print("Enter fee: ");
        double f2 = sc.nextDouble();

        Course course2 = new Course(c2, d2, f2);
        course2.displayCourseDetails();

        sc.close();
    }
}
