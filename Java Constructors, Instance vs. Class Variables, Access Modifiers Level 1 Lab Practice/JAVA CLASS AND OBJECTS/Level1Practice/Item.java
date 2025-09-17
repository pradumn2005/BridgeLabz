import java.util.*;

class Item {
    int itemCode;
    String itemName;
    double price;
    Item(int code, String name, double p) {
        itemCode = code;
        itemName = name;
        price = p;
    }
    void display(int qty) {
        System.out.println("Code: " + itemCode);
        System.out.println("Name: " + itemName);
        System.out.println("Price: " + price);
        System.out.println("Total Cost: " + (price * qty));
    }
    public static void main(String[] args) {
        Item i = new Item(101, "Pen", 10);
        i.display(5);
    }
}
