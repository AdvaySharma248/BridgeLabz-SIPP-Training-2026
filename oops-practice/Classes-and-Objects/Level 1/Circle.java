import java.util.Scanner;

public class Circle {
    double radius;

    double calculateArea() {
        return 3.14159 * radius * radius;
    }

    double calculateCircumference() {
        return 2 * 3.14159 * radius;
    }

    void display() {
        System.out.println("Radius: " + radius);
        System.out.println("Area: " + calculateArea());
        System.out.println("Circumference: " + calculateCircumference());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter radius of the circle: ");
        double r = sc.nextDouble();

        Circle c = new Circle();
        c.radius = r;
        c.display();

        sc.close();
    }
}
