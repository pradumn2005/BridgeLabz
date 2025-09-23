import java.util.*;

class Professor {
    String name; Professor(String n){ name=n; }
    public String toString(){ return name; }
}

class Course {
    String title; Professor prof; ArrayList<Student> students=new ArrayList<>();
    Course(String t){ title=t; }
    void assignProfessor(Professor p){ prof=p; }
    void addStudent(Student s){ students.add(s); }
    public String toString(){ return title+" taught by "+prof+" with "+students; }
}

class Student {
    String name; Student(String n){ name=n; }
    void enrollCourse(Course c){ c.addStudent(this); }
    public String toString(){ return name; }
}

public class Main5 {
    public static void main(String[] args){
        Professor p=new Professor("Dr. Rao");
        Course c=new Course("AI");
        c.assignProfessor(p);
        Student s1=new Student("Amit"); Student s2=new Student("Riya");
        s1.enrollCourse(c); s2.enrollCourse(c);
        System.out.println(c);
    }
}
