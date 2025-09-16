import java.util.*;

class HotelBooking {
    String guestName, roomType;
    int nights;
    HotelBooking() {
        guestName = "Unknown";
        roomType = "Standard";
        nights = 1;
    }
    HotelBooking(String g, String r, int n) {
        guestName = g;
        roomType = r;
        nights = n;
    }
    HotelBooking(HotelBooking h) {
        guestName = h.guestName;
        roomType = h.roomType;
        nights = h.nights;
    }
    void display() {
        System.out.println(guestName + " booked " + roomType + " for " + nights + " nights");
    }
    public static void main(String[] args) {
        HotelBooking h1 = new HotelBooking();
        HotelBooking h2 = new HotelBooking("Ravi", "Deluxe", 3);
        HotelBooking h3 = new HotelBooking(h2);
        h1.display();
        h2.display();
        h3.display();
    }
}
