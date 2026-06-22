import java.util.Scanner;

class Circle {
    double radius;

    Circle() {
        this(1.0);
    }

    Circle(double r) {
        radius = r;
    }

    double getArea() {
        return 3.14159 * radius * radius;
    }

    void display() {
        System.out.println("Radius: " + radius);
        System.out.println("Area: " + getArea());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Using default constructor:");
        Circle c1 = new Circle();
        c1.display();

        System.out.print("Enter radius: ");
        double r = sc.nextDouble();

        System.out.println("Using parameterized constructor:");
        Circle c2 = new Circle(r);
        c2.display();

        sc.close();
    }
}
