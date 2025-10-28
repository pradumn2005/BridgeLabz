import library.books.Book;
import library.members.Member;
import library.transactions.Transaction;

public class MainApp {
    public static void main(String[] args) {

        System.out.println("=== Library Management System ===\n");


        Book book1 = new Book("Java Programming", "James Gosling", "ISBN12345");
        book1.displayBookDetails();
        System.out.println();


        Member member1 = new Member("Pradumn Gupta", 101);
        member1.displayMemberDetails();
        System.out.println();


        Transaction t1 = new Transaction(book1, member1);
        t1.issueBook();
    }
}
