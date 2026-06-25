public class Student extends Person {
    final int studentId;
    double gpa;

    public Student(String name, int studentId, double gpa) {
        super(name);
        this.studentId = studentId;
        this.gpa = gpa;
    }

    public String toString() {
        return super.toString() + ", Student ID: " + studentId + ", GPA: " + gpa;
    }
}
