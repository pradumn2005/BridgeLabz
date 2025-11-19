public class Truck extends Vehicle {

    public Truck(String id) {
        super(id);
    }

    @Override
    public String getType() {
        return "Truck";
    }
}
