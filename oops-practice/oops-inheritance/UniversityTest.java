public class UniversityTest {
    public static void main(String[] args) {
        GradStudent grad = new GradStudent("Alice", 123, 3.9, "Machine Learning");
        
        System.out.println(grad.toString());

        if (grad instanceof Student) {
            System.out.println("GradStudent IS-A Student");
        }
        if (grad instanceof Person) {
            System.out.println("GradStudent IS-A Person");
        }
    }
}
