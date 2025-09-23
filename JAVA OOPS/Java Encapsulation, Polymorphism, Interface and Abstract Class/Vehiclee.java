abstract class Vehiclee {
    private int vehicleId;
    private String driverName;
    private double ratePerKm;
    public Vehicle(int v,String d,double r){vehicleId=v;driverName=d;ratePerKm=r;}
    public void getVehicleDetails(){System.out.println(vehicleId+" "+driverName+" "+ratePerKm);}
    public abstract double calculateFare(double dist);
}

interface GPS {
    String getCurrentLocation();
    void updateLocation(String loc);
}

class Car extends Vehicle implements GPS {
    public Car(int v,String d,double r){super(v,d,r);}
    public double calculateFare(double dist){return dist*15;}
    public String getCurrentLocation(){return "Location Car";}
    public void updateLocation(String loc){System.out.println("Car "+loc);}
}

class Bike extends Vehicle implements GPS {
    public Bike(int v,String d,double r){super(v,d,r);}
    public double calculateFare(double dist){return dist*8;}
    public String getCurrentLocation(){return "Location Bike";}
    public void updateLocation(String loc){System.out.println("Bike "+loc);}
}

class Auto extends Vehicle implements GPS {
    public Auto(int v,String d,double r){super(v,d,r);}
    public double calculateFare(double dist){return dist*10;}
    public String getCurrentLocation(){return "Location Auto";}
    public void updateLocation(String loc){System.out.println("Auto "+loc);}
}

public class Main8 {
    public static void main(String[] args) {
        Vehicle v=new Bike(1,"Sam",0);
        v.getVehicleDetails();
        System.out.println(v.calculateFare(10));
    }
}
