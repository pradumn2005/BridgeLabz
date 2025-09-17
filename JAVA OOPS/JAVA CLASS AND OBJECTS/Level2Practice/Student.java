import java.util.*;
class Student {
    String name;
    int rollNumber;
    int marks;
    Student(String n, int r, int m) {
        name = n;
        rollNumber = r;
        marks = m;
    }
    String grade() {
        if (marks >= 90) return "A";
        else if (marks >= 75) return "B";
        else if (marks >= 50) return "C";
        else return "D";
    }
    void display() {
        System.out.println("Name: " + name);
        System.out.println("Roll No: " + rollNumber);
        System.out.println("Marks: " + marks);
        System.out.println("Grade: " + grade());
    }
    public static void main(String[] args) {
        Student s = new Student("Rahul", 101, 82);
        s.display();
    }
}
