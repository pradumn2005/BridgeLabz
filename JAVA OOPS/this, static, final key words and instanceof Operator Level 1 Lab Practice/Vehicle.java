class Vehicle {
    private static double registrationFee = 5000;

    private final String registrationNumber;
    private String ownerName;
    private String vehicleType;

    Vehicle(String registrationNumber, String ownerName, String vehicleType) {
        this.registrationNumber = registrationNumber;
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    public static void updateRegistrationFee(double fee) {
        registrationFee = fee;
    }

    void display() {
        if (this instanceof Vehicle) {
            System.out.println("Registration No: " + registrationNumber);
            System.out.println("Owner: " + ownerName);
            System.out.println("Type: " + vehicleType);
            System.out.println("Fee: " + registrationFee);
        }
    }

    public static void main(String[] args) {
        Vehicle v = new Vehicle("UP14AB1234", "Ankit", "Car");
        v.display();
        Vehicle.updateRegistrationFee(7000);
        v.display();
    }
}
