import java.util.*;

class Book {
    String title, author;
    double price;
    Book(String t, String a, double p) {
        title = t;
        author = a;
        price = p;
    }
    void display() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: " + price);
    }
    public static void main(String[] args) {
        Book b = new Book("Java", "James Gosling", 500);
        b.display();
    }
}
