import java.util.*;

class LibraryBook {
    String title, author;
    double price;
    boolean available;
    LibraryBook(String t, String a, double p) {
        title = t;
        author = a;
        price = p;
        available = true;
    }
    void borrow() {
        if (available) {
            available = false;
            System.out.println(title + " borrowed");
        } else {
            System.out.println(title + " not available");
        }
    }
    void display() {
        System.out.println(title + " by " + author + " price: " + price + " available: " + available);
    }
    public static void main(String[] args) {
        LibraryBook b = new LibraryBook("C++", "Bjarne", 400);
        b.display();
        b.borrow();
        b.display();
    }
}
