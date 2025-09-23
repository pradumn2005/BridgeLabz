abstract class Vehicle {
    private String vehicleNumber,type;
    private double rentalRate;
    public Vehicle(String v,String t,double r){vehicleNumber=v;type=t;rentalRate=r;}
    public double getRentalRate(){return rentalRate;}
    public abstract double calculateRentalCost(int days);
}

interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}

class Car extends Vehicle implements Insurable {
    public Car(String v,double r){super(v,"Car",r);}
    public double calculateRentalCost(int d){return getRentalRate()*d;}
    public double calculateInsurance(){return 2000;}
    public String getInsuranceDetails(){return "Car Insurance";}
}

class Bike extends Vehicle implements Insurable {
    public Bike(String v,double r){super(v,"Bike",r);}
    public double calculateRentalCost(int d){return getRentalRate()*d;}
    public double calculateInsurance(){return 500;}
    public String getInsuranceDetails(){return "Bike Insurance";}
}

class Truck extends Vehicle implements Insurable {
    public Truck(String v,double r){super(v,"Truck",r);}
    public double calculateRentalCost(int d){return getRentalRate()*d;}
    public double calculateInsurance(){return 3000;}
    public String getInsuranceDetails(){return "Truck Insurance";}
}

public class Main3 {
    public static void main(String[] args) {
        Vehicle v=new Car("C1",1000);
        System.out.println(v.calculateRentalCost(5));
        System.out.println(((Insurable)v).calculateInsurance());
    }
}
