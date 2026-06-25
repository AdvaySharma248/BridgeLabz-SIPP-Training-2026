package polymorphism;

class Vehicle {
    public void fuelCost(int km) {
        System.out.println("Calculating fuel cost for vehicle...");
    }
}

class Car extends Vehicle {
    @Override
    public void fuelCost(int km) {
        double cost = km * 10.5; // Beginner level simple calculation
        System.out.println("Car fuel cost for " + km + " km: " + cost);
    }
}

class Bus extends Vehicle {
    @Override
    public void fuelCost(int km) {
        double cost = km * 25.0;
        System.out.println("Bus fuel cost for " + km + " km: " + cost);
    }
}

class Bike extends Vehicle {
    @Override
    public void fuelCost(int km) {
        double cost = km * 2.5;
        System.out.println("Bike fuel cost for " + km + " km: " + cost);
    }
}

// Requirement: Add a new ElectricCar without changing existing code (OCP)
class ElectricCar extends Vehicle {
    @Override
    public void fuelCost(int km) {
        double cost = km * 1.5; // Electricity is cheaper
        System.out.println("Electric Car charging cost for " + km + " km: " + cost);
    }
}

public class TransportCompany {
    public static void main(String[] args) {
        // Storing different vehicles in an array
        Vehicle[] fleet = new Vehicle[4];
        fleet[0] = new Car();
        fleet[1] = new Bus();
        fleet[2] = new Bike();
        fleet[3] = new ElectricCar();

        System.out.println("--- Transport Company Fleet Fuel Costs ---");
        for (Vehicle v : fleet) {
            // Using instanceof before casting (though not strictly needed for fuelCost since it's overridden)
            // But requirement says to use it.
            if (v instanceof Car) {
                Car c = (Car) v;
                c.fuelCost(100);
            } else if (v instanceof Bus) {
                Bus b = (Bus) v;
                b.fuelCost(100);
            } else if (v instanceof Bike) {
                Bike bk = (Bike) v;
                bk.fuelCost(100);
            } else if (v instanceof ElectricCar) {
                ElectricCar ec = (ElectricCar) v;
                ec.fuelCost(100);
            }
        }
    }
}
