import java.util.ArrayList;
import java.util.List;

public class FleetManager<T extends Vehicle> {

    private List<T> fleet;

    public FleetManager() {
        this.fleet = new ArrayList<>();
    }

    public void addVehicle(T vehicle) {
        fleet.add(vehicle);
    }

    public void showFleet() {
        if (!fleet.isEmpty()) {
            System.out.println("Fleet of " + fleet.get(0).getType() + "s:");
            for (T vehicle : fleet) {
                System.out.println("  - ID: " + vehicle.getId());
            }
        } else {
            System.out.println("Fleet is empty.");
        }
    }

    public static void main(String[] args) {
        FleetManager<Truck> truckFleet = new FleetManager<>();
        truckFleet.addVehicle(new Truck("T101"));
        truckFleet.addVehicle(new Truck("T102"));
        truckFleet.showFleet();

        FleetManager<Bike> bikeFleet = new FleetManager<>();
        bikeFleet.addVehicle(new Bike("B201"));
        bikeFleet.addVehicle(new Bike("B202"));
        bikeFleet.showFleet();
    }
}
