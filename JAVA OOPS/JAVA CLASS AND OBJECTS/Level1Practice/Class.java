import java.util.*;

class Circle {
    double radius;
    Circle(double r) {
        radius = r;
    }
    double area() {
        return 3.14 * radius * radius;
    }
    double circumference() {
        return 2 * 3.14 * radius;
    }
    void display() {
        System.out.println("Area: " + area());
        System.out.println("Circumference: " + circumference());
    }
    public static void main(String[] args) {
        Circle c = new Circle(5);
        c.display();
    }
}
