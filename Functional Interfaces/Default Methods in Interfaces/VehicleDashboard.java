
interface VehicleDashboard {
    void displaySpeed();
    default void displayBattery() { System.out.println("Battery: 80%"); }
}

class ElectricCar implements VehicleDashboard {
    public void displaySpeed() { System.out.println("Speed: 60 km/h"); }
}

public class DashboardDemo {
    public static void main(String[] args) {
        ElectricCar c = new ElectricCar();
        c.displaySpeed();
        c.displayBattery();
    }
}
