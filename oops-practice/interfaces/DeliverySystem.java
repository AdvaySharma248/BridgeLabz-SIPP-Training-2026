package interfaces;

interface FoodDelivery {
    void deliverFood(String item);
    
    default void trackOrder() {
        System.out.println("Food Delivery: Order is being prepared and will be out for delivery soon.");
    }

    // Requirement: Add a static method generateDeliveryCode() in one interface
    static String generateDeliveryCode() {
        return "FOOD-" + (int)(Math.random() * 9000 + 1000);
    }
}

interface GroceryDelivery {
    void deliverGroceries(String item);

    default void trackOrder() {
        System.out.println("Grocery Delivery: Items are being packed from the warehouse.");
    }
}

// Requirement: Implement both interfaces in DeliveryExecutive
class DeliveryExecutive implements FoodDelivery, GroceryDelivery {
    String name;

    public DeliveryExecutive(String name) {
        this.name = name;
    }

    @Override
    public void deliverFood(String item) {
        System.out.println(name + " is delivering Food: " + item);
        System.out.println("Delivery Code: " + FoodDelivery.generateDeliveryCode());
    }

    @Override
    public void deliverGroceries(String item) {
        System.out.println(name + " is delivering Groceries: " + item);
        // Using a simple logic for grocery code since it's not in the interface
        System.out.println("Delivery Code: GROC-" + (int)(Math.random() * 9000 + 1000));
    }

    // Resolving conflict
    @Override
    public void trackOrder() {
        System.out.println("--- Tracking Order Status ---");
        FoodDelivery.super.trackOrder();
        GroceryDelivery.super.trackOrder();
    }
}

public class DeliverySystem {
    public static void main(String[] args) {
        // Requirement: Store customer names in a String[]
        String[] customers = {"Alice", "Bob", "Charlie", "David"};
        
        DeliveryExecutive executive = new DeliveryExecutive("Mike");

        System.out.println("--- Delivery Partner System ---");
        
        // Processing deliveries
        System.out.println("Processing for " + customers[0]);
        executive.deliverFood("Pizza");
        executive.trackOrder();
        System.out.println("-------------------------");

        System.out.println("Processing for " + customers[1]);
        executive.deliverGroceries("Fresh Fruits");
        executive.trackOrder();
        System.out.println("-------------------------");

        System.out.println("Processing for " + customers[2]);
        executive.deliverFood("Burger & Fries");
        System.out.println("-------------------------");

        System.out.println("Processing for " + customers[3]);
        executive.deliverGroceries("Milk and Eggs");
        System.out.println("-------------------------");
    }
}
