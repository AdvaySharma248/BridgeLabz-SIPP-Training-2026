import java.util.Scanner;

class ParkingSystem {
    int bigSlots;
    int mediumSlots;
    int smallSlots;

    ParkingSystem(int big, int medium, int small) {
        this.bigSlots = big;
        this.mediumSlots = medium;
        this.smallSlots = small;
    }

    boolean addCar(int carType) {
        if (carType == 1) {
            if (bigSlots > 0) {
                bigSlots--;
                return true;
            }
            return false;
        } else if (carType == 2) {
            if (mediumSlots > 0) {
                mediumSlots--;
                return true;
            }
            return false;
        } else if (carType == 3) {
            if (smallSlots > 0) {
                smallSlots--;
                return true;
            }
            return false;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ParkingSystem ps = new ParkingSystem(1, 1, 0);

        System.out.println("Add big car: " + ps.addCar(1));
        System.out.println("Add medium car: " + ps.addCar(2));
        System.out.println("Add small car: " + ps.addCar(3));
        System.out.println("Add big car again: " + ps.addCar(1));

        sc.close();
    }
}
