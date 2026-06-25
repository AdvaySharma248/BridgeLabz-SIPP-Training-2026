public class GradStudent extends Student {
    String thesis;

    public GradStudent(String name, int studentId, double gpa, String thesis) {
        super(name, studentId, gpa);
        this.thesis = thesis;
    }

    public String toString() {
        return super.toString() + ", Thesis: " + thesis;
    }
}
