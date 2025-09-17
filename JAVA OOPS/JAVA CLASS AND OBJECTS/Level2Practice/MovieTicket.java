import java.util.*;

class MovieTicket {
    String movieName;
    int seatNumber;
    double price;
    void book(String m, int s, double p) {
        movieName = m;
        seatNumber = s;
        price = p;
    }
    void display() {
        System.out.println("Movie: " + movieName);
        System.out.println("Seat No: " + seatNumber);
        System.out.println("Price: " + price);
    }
    public static void main(String[] args) {
        MovieTicket t = new MovieTicket();
        t.book("Inception", 12, 250);
        t.display();
    }
}
