public abstract class Vehicle {

    private String id;

    public Vehicle(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public abstract String getType();
}
