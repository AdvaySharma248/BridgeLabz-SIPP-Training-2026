public class Person {
    String name;
    int id;

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String toString() {
        return "Name: " + name + ", ID: " + id;
    }
}
