import java.util.*;

class Student {
    String name;
    ArrayList<Course> courses=new ArrayList<>();
    Student(String n){ name=n; }
    void enroll(Course c){ courses.add(c); c.students.add(this); }
    void showCourses(){ System.out.println(name+" enrolled in "+courses); }
    public String toString(){ return name; }
}

class Course {
    String title;
    ArrayList<Student> students=new ArrayList<>();
    Course(String t){ title=t; }
    void showStudents(){ System.out.println(title+" has "+students); }
    public String toString(){ return title; }
}

class School {
    String name;
    ArrayList<Student> students=new ArrayList<>();
    School(String n){ name=n; }
    void addStudent(Student s){ students.add(s); }
}

public class Main1 {
    public static void main(String[] args){
        School s=new School("ABC School");
        Student st1=new Student("Amit"); Student st2=new Student("Neha");
        Course c1=new Course("Math"); Course c2=new Course("Science");
        s.addStudent(st1); s.addStudent(st2);
        st1.enroll(c1); st1.enroll(c2);
        st2.enroll(c2);
        st1.showCourses(); st2.showCourses();
        c2.showStudents();
    }
}
