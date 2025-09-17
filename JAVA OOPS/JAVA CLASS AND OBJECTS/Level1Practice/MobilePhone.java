import java.util*;

class MobilePhone {
    String brand, model;
    double price;
    MobilePhone(String b, String m, double p) {
        brand = b;
        model = m;
        price = p;
    }
    void display() {
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Price: " + price);
    }
    public static void main(String[] args) {
        MobilePhone m = new MobilePhone("Samsung", "S25", 70000);
        m.display();
    }
}
