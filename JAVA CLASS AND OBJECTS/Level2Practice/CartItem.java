import java.util.*;
class CartItem {
    String itemName;
    double price;
    int quantity;
    CartItem(String n, double p, int q) {
        itemName = n;
        price = p;
        quantity = q;
    }
    void add(int q) {
        quantity += q;
    }
    void remove(int q) {
        if (q <= quantity) quantity -= q;
    }
    void display() {
        System.out.println("Item: " + itemName);
        System.out.println("Price: " + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("Total: " + (price * quantity));
    }
    public static void main(String[] args) {
        CartItem c = new CartItem("Shoes", 2000, 2);
        c.add(1);
        c.remove(1);
        c.display();
    }
}
