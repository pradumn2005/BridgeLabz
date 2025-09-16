class Book {
    public String ISBN;
    protected String title;
    private String author;
    Book(String i, String t, String a) {
        ISBN = i;
        title = t;
        author = a;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String a) {
        author = a;
    }
}
class EBook extends Book {
    double fileSize;
    EBook(String i, String t, String a, double f) {
        super(i, t, a);
        fileSize = f;
    }
    void display() {
        System.out.println("ISBN: " + ISBN);
        System.out.println("Title: " + title);
        System.out.println("Author: " + getAuthor());
        System.out.println("File Size: " + fileSize + "MB");
    }
    public static void main(String[] args) {
        EBook e = new EBook("12345", "Java Basics", "James", 5.2);
        e.display();
        e.setAuthor("James Gosling");
        System.out.println("Updated Author: " + e.getAuthor());
    }
}
