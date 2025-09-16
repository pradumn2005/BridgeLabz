import java.util.*;

class CarRental {
    String customerName, carModel;
    int rentalDays;
    double costPerDay = 1000;
    CarRental(String c, String m, int d) {
        customerName = c;
        carModel = m;
        rentalDays = d;
    }
    double totalCost() {
        return rentalDays * costPerDay;
    }
    void display() {
        System.out.println(customerName + " rented " + carModel + " for " + rentalDays + " days, Total: " + totalCost());
    }
    public static void main(String[] args) {
        CarRental r = new CarRental("Priya", "Swift", 5);
        r.display();
    }
}
