class Person {
    String name;
    int age;
}

class Teacher extends Person {
    String subject;
    void displayRole() { System.out.println("Teacher of "+subject); }
}

class Student extends Person {
    int grade;
    void displayRole() { System.out.println("Student of grade "+grade); }
}

class Staff extends Person {
    String role;
    void displayRole() { System.out.println("Staff: "+role); }
}

public class Main9 {
    public static void main(String[] args) {
        Person p=new Teacher();
        ((Teacher)p).subject="Math";
        ((Teacher)p).displayRole();
    }
}
