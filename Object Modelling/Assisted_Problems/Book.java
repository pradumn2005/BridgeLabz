import java.util.*;

class Book {
    String title, author;
    Book(String t, String a){ title=t; author=a; }
    public String toString(){ return title+" by "+author; }
}

class Library {
    ArrayList<Book> books = new ArrayList<>();
    void addBook(Book b){ books.add(b); }
    void showBooks(){ for(Book b:books) System.out.println(b); }
}

public class Main {
    public static void main(String[] args){
        Book b1=new Book("Java","James");
        Book b2=new Book("Python","Guido");
        Library l1=new Library(); Library l2=new Library();
        l1.addBook(b1); l1.addBook(b2);
        l2.addBook(b1); // same book in another library
        l1.showBooks(); l2.showBooks();
    }
}
