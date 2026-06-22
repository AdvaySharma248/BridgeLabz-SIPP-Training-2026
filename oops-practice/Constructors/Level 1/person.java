import java.util.Scanner;

class Person {
    String name;
    int age;

    Person(String n, int a) {
        name = n;
        age = a;
    }

    Person(Person p) {
        name = p.name;
        age = p.age;
    }

    void display() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter name: ");
        String n = sc.nextLine();
        System.out.print("Enter age: ");
        int a = sc.nextInt();

        Person p1 = new Person(n, a);
        System.out.println("Original person:");
        p1.display();

        Person p2 = new Person(p1);
        System.out.println("Copied person:");
        p2.display();

        sc.close();
    }
}
