class BookNode {
    String title;
    String author;
    String genre;
    int bookId;
    boolean isAvailable;
    BookNode next;
    BookNode prev;

    public BookNode(String title, String author, String genre, int id, boolean avail) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookId = id;
        this.isAvailable = avail;
    }
}

public class LibraryManagementSystem {
    BookNode head;
    BookNode tail;

    public void addBook(String title, String author, String genre, int id) {
        BookNode newNode = new BookNode(title, author, genre, id, true);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public void removeBook(int id) {
        BookNode temp = head;
        while (temp != null && temp.bookId != id) {
            temp = temp.next;
        }
        if (temp == null) return;

        if (temp == head) head = temp.next;
        if (temp == tail) tail = temp.prev;
        if (temp.prev != null) temp.prev.next = temp.next;
        if (temp.next != null) temp.next.prev = temp.prev;
    }

    public void updateStatus(int id, boolean status) {
        BookNode temp = head;
        while (temp != null) {
            if (temp.bookId == id) {
                temp.isAvailable = status;
                return;
            }
            temp = temp.next;
        }
    }

    public void displayBooks() {
        BookNode temp = head;
        while (temp != null) {
            System.out.println(temp.bookId + ": " + temp.title + " [" + (temp.isAvailable ? "Avail" : "Out") + "]");
            temp = temp.next;
        }
    }

    public void countBooks() {
        int count = 0;
        BookNode temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        System.out.println("Total Books: " + count);
    }

    public static void main(String[] args) {
        LibraryManagementSystem lib = new LibraryManagementSystem();
        lib.addBook("Java Basics", "John Doe", "Education", 1);
        lib.addBook("Data Structures", "Jane Doe", "Education", 2);
        lib.displayBooks();
        lib.updateStatus(1, false);
        lib.displayBooks();
        lib.countBooks();
    }
}
