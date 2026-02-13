class TicketNode {
    int ticketId;
    String customerName;
    String movieName;
    int seatNumber;
    TicketNode next;

    public TicketNode(int id, String customer, String movie, int seat) {
        this.ticketId = id;
        this.customerName = customer;
        this.movieName = movie;
        this.seatNumber = seat;
    }
}

public class TicketReservationSystem {
    TicketNode head;
    TicketNode tail;

    public void bookTicket(int id, String customer, String movie, int seat) {
        TicketNode newNode = new TicketNode(id, customer, movie, seat);
        if (head == null) {
            head = newNode;
            tail = newNode;
            newNode.next = head;
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
    }

    public void cancelTicket(int id) {
        if (head == null) return;
        TicketNode curr = head;
        TicketNode prev = tail;
        
        do {
            if (curr.ticketId == id) {
                if (curr == head && curr == tail) {
                    head = null;
                    tail = null;
                } else {
                    if (curr == head) head = head.next;
                    if (curr == tail) tail = prev;
                    prev.next = curr.next;
                }
                System.out.println("Ticket " + id + " cancelled.");
                return;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != head);
    }

    public void displayTickets() {
        if (head == null) {
            System.out.println("No tickets.");
            return;
        }
        TicketNode temp = head;
        do {
            System.out.println("Ticket " + temp.ticketId + ": " + temp.customerName);
            temp = temp.next;
        } while (temp != head);
    }

    public static void main(String[] args) {
        TicketReservationSystem sys = new TicketReservationSystem();
        sys.bookTicket(101, "John", "Matrix", 5);
        sys.bookTicket(102, "Sara", "Matrix", 6);
        sys.displayTickets();
        sys.cancelTicket(101);
        sys.displayTickets();
    }
}
