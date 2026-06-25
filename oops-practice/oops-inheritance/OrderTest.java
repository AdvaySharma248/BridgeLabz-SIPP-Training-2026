public class OrderTest {
    public static void main(String[] args) {
        Order o1 = new Order(1, "2024-06-01");
        ShippedOrder o2 = new ShippedOrder(2, "2024-06-02", "XYZ123");
        DeliveredOrder o3 = new DeliveredOrder(3, "2024-06-03", "ABC456", "2024-06-05");

        System.out.println("Order 1: " + o1.getOrderStatus());
        System.out.println("Order 2: " + o2.getOrderStatus());
        System.out.println("Order 3: " + o3.getOrderStatus());
    }
}
