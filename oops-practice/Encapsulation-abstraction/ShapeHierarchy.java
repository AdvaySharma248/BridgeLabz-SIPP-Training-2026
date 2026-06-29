abstract class Shape {
    abstract double area();
    abstract double perimeter();
}

class Circle extends Shape {
    private double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    double getRadius() {
        return radius;
    }

    double area() {
        return 3.14159 * radius * radius;
    }

    double perimeter() {
        return 2 * 3.14159 * radius;
    }
}

class Rectangle extends Shape {
    private double length;
    private double width;

    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    double getLength() {
        return length;
    }

    void setLength(double length) {
        this.length = length;
    }

    double getWidth() {
        return width;
    }

    void setWidth(double width) {
        this.width = width;
    }

    double area() {
        return length * width;
    }

    double perimeter() {
        return 2 * (length + width);
    }
}

class Triangle extends Shape {
    private double side1;
    private double side2;
    private double side3;

    Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    double getSide1() {
        return side1;
    }

    void setSide1(double side1) {
        this.side1 = side1;
    }

    double getSide2() {
        return side2;
    }

    void setSide2(double side2) {
        this.side2 = side2;
    }

    double getSide3() {
        return side3;
    }

    void setSide3(double side3) {
        this.side3 = side3;
    }

    double area() {
        double s = (side1 + side2 + side3) / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    double perimeter() {
        return side1 + side2 + side3;
    }
}

public class ShapeHierarchy {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(5);
        shapes[1] = new Rectangle(4, 6);
        shapes[2] = new Triangle(3, 4, 5);

        System.out.println("Shape Area Report:");
        System.out.println("-------------------");
        for (int i = 0; i < shapes.length; i++) {
            System.out.println("Shape " + (i + 1) + ":");
            System.out.println("Area: " + shapes[i].area());
            System.out.println("Perimeter: " + shapes[i].perimeter());
            System.out.println();
        }
    }
}
