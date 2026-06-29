abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    String getItemName() {
        return itemName;
    }

    void setItemName(String itemName) {
        this.itemName = itemName;
    }

    double getPrice() {
        return price;
    }

    void setPrice(double price) {
        this.price = price;
    }

    int getQuantity() {
        return quantity;
    }

    void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    abstract double calculateTotalPrice();

    void displayItemDetails() {
        System.out.println("Item Name: " + itemName);
        System.out.println("Price: " + price);
        System.out.println("Quantity: " + quantity);
    }
}

class VegItem extends FoodItem {
    double calculateTotalPrice() {
        return getPrice() * getQuantity();
    }
}

class NonVegItem extends FoodItem {
    private double serviceCharge;

    double getServiceCharge() {
        return serviceCharge;
    }

    void setServiceCharge(double serviceCharge) {
        this.serviceCharge = serviceCharge;
    }

    double calculateTotalPrice() {
        return (getPrice() * getQuantity()) + serviceCharge;
    }
}

public class OnlineFoodDeliverySystem {
    public static void main(String[] args) {
        VegItem veg = new VegItem();
        veg.setItemName("Paneer Butter Masala");
        veg.setPrice(250);
        veg.setQuantity(2);

        NonVegItem nonVeg = new NonVegItem();
        nonVeg.setItemName("Chicken Curry");
        nonVeg.setPrice(350);
        nonVeg.setQuantity(2);
        nonVeg.setServiceCharge(50);

        System.out.println("Veg Item Details:");
        veg.displayItemDetails();
        System.out.println("Total Price: " + veg.calculateTotalPrice());
        System.out.println();

        System.out.println("Non-Veg Item Details:");
        nonVeg.displayItemDetails();
        System.out.println("Total Price: " + nonVeg.calculateTotalPrice());
    }
}
