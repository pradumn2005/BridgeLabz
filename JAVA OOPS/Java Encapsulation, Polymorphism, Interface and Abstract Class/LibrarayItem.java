abstract class LibraryItem {
    private int itemId;
    private String title,author;
    public LibraryItem(int i,String t,String a){itemId=i;title=t;author=a;}
    public void getItemDetails(){System.out.println(itemId+" "+title+" "+author);}
    public abstract int getLoanDuration();
}

interface Reservable {
    void reserveItem();
    boolean checkAvailability();
}

class Book extends LibraryItem implements Reservable {
    public Book(int i,String t,String a){super(i,t,a);}
    public int getLoanDuration(){return 14;}
    public void reserveItem(){System.out.println("Book Reserved");}
    public boolean checkAvailability(){return true;}
}

class Magazine extends LibraryItem implements Reservable {
    public Magazine(int i,String t,String a){super(i,t,a);}
    public int getLoanDuration(){return 7;}
    public void reserveItem(){System.out.println("Magazine Reserved");}
    public boolean checkAvailability(){return true;}
}

class DVD extends LibraryItem implements Reservable {
    public DVD(int i,String t,String a){super(i,t,a);}
    public int getLoanDuration(){return 3;}
    public void reserveItem(){System.out.println("DVD Reserved");}
    public boolean checkAvailability(){return false;}
}

public class Main5 {
    public static void main(String[] args) {
        LibraryItem l=new Book(1,"Java","James");
        l.getItemDetails();
        System.out.println(l.getLoanDuration());
    }
}
