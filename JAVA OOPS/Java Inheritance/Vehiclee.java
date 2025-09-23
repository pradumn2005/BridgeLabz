class Vehiclee {
    int maxSpeed;
    String model;
}

interface Refuelable {
    void refuel();
}

class ElectricVehicle extends Vehicle {
    void charge() { System.out.println("Charging"); }
}

class PetrolVehicle extends Vehicle implements Refuelable {
    public void refuel() { System.out.println("Refueling Petrol"); }
}

public class Main11 {
    public static void main(String[] args) {
        PetrolVehicle p=new PetrolVehicle();
        p.refuel();
    }
}
