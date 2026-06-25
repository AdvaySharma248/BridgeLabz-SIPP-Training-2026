public class RestaurantTest {
    public static void main(String[] args) {
        Chef c = new Chef("Gordon", 1);
        Waiter w = new Waiter("Marco", 2);

        c.performDuties();
        w.performDuties();
    }
}
