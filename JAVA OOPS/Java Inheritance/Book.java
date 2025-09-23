class Book {
    String title;
    int publicationYear;
}

class Author extends Book {
    String name;
    String bio;
    void displayInfo() {
        System.out.println(title+" "+publicationYear+" "+name+" "+bio);
    }
}

public class Main4 {
    public static void main(String[] args) {
        Author a=new Author();
        a.title="Java"; a.publicationYear=2024; a.name="James"; a.bio="Creator";
        a.displayInfo();
    }
}
