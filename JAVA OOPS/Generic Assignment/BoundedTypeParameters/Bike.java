public class Bike extends Vehicle {

    public Bike(String id) {
        super(id);
    }

    @Override
    public String getType() {
        return "Bike";
    }
}
