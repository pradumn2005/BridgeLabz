class Vehicle {
    int maxSpeed;
    String fuelType;
    void displayInfo() {
        System.out.println(maxSpeed + " " + fuelType);
    }
}

class Car extends Vehicle {
    int seatCapacity;
    void displayInfo() {
        System.out.println(maxSpeed + " " + fuelType + " " + seatCapacity);
    }
}

class Truck extends Vehicle {
    int loadCapacity;
    void displayInfo() {
        System.out.println(maxSpeed + " " + fuelType + " " + loadCapacity);
    }
}

class Motorcycle extends Vehicle {
    String type;
    void displayInfo() {
        System.out.println(maxSpeed + " " + fuelType + " " + type);
    }
}

public class Main3 {
    public static void main(String[] args) {
        Vehicle[] v = {new Car(), new Truck(), new Motorcycle()};
        v[0].maxSpeed=200; ((Car)v[0]).seatCapacity=4; v[0].fuelType="Petrol";
        v[1].maxSpeed=100; ((Truck)v[1]).loadCapacity=5000; v[1].fuelType="Diesel";
        v[2].maxSpeed=150; ((Motorcycle)v[2]).type="Sports"; v[2].fuelType="Petrol";
        for(Vehicle x:v) x.displayInfo();
    }
}
