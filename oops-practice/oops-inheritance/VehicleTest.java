public class VehicleTest {
    public static void main(String[] args) {
        ElectricVehicle ev = new ElectricVehicle(200, "Tesla");
        PetrolVehicle pv = new PetrolVehicle(180, "Toyota");

        ev.charge();
        pv.refuel();
    }
}
