class MovieNode {
    String title;
    String director;
    int year;
    double rating;
    MovieNode next;
    MovieNode prev;

    public MovieNode(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
    }
}

public class MovieManagementSystem {
    MovieNode head;
    MovieNode tail;

    public void addAtEnd(String title, String director, int year, double rating) {
        MovieNode newNode = new MovieNode(title, director, year, rating);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public void removeByTitle(String title) {
        if (head == null) return;
        MovieNode temp = head;
        while (temp != null && !temp.title.equals(title)) {
            temp = temp.next;
        }
        if (temp == null) return;

        if (temp == head) {
            head = head.next;
            if (head != null) head.prev = null;
            else tail = null;
        } else if (temp == tail) {
            tail = tail.prev;
            tail.next = null;
        } else {
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }
    }

    public void searchByDirector(String director) {
        MovieNode temp = head;
        while (temp != null) {
            if (temp.director.equals(director)) {
                System.out.println("Found Movie: " + temp.title);
            }
            temp = temp.next;
        }
    }

    public void displayForward() {
        MovieNode temp = head;
        while (temp != null) {
            System.out.println(temp.title + " (" + temp.year + ")");
            temp = temp.next;
        }
    }

    public void displayReverse() {
        MovieNode temp = tail;
        while (temp != null) {
            System.out.println(temp.title + " (" + temp.year + ")");
            temp = temp.prev;
        }
    }

    public static void main(String[] args) {
        MovieManagementSystem list = new MovieManagementSystem();
        list.addAtEnd("Inception", "Nolan", 2010, 8.8);
        list.addAtEnd("Avatar", "Cameron", 2009, 7.8);
        list.displayForward();
        list.displayReverse();
        list.removeByTitle("Avatar");
        list.displayForward();
    }
}
