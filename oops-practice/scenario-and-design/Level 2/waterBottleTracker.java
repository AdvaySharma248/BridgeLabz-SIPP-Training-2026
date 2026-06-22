import java.util.Scanner;

class WaterBottle {
    String ownerName;
    int dailyTarget;

    WaterBottle(String ownerName, int dailyTarget) {
        this.ownerName = ownerName;
        this.dailyTarget = dailyTarget;
    }

    void displayBottleInfo() {
        System.out.println("Owner: " + ownerName);
        System.out.println("Daily Target: " + dailyTarget + " ml");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        WaterBottle b1 = new WaterBottle("Alice", 2000);
        WaterBottle b2 = new WaterBottle("Bob", 2500);

        b1.displayBottleInfo();
        System.out.println();
        b2.displayBottleInfo();

        sc.close();
    }
}
