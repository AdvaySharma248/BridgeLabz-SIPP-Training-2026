public class Waiter extends Person implements Worker {
    public Waiter(String name, int id) {
        super(name, id);
    }

    public void performDuties() {
        System.out.println(name + " is serving.");
    }
}
