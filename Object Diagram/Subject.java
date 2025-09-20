import java.util.*;

class Subject {
    String name; int marks;
    Subject(String n,int m){ name=n; marks=m; }
}

class Student {
    String name; ArrayList<Subject> subs=new ArrayList<>();
    Student(String n){ name=n; }
    void addSub(Subject s){ subs.add(s); }
}

class GradeCalculator {
    String calc(Student s){
        int sum=0;
        for(Subject sub:s.subs) sum+=sub.marks;
        int avg=sum/s.subs.size();
        return avg>=90?"A":avg>=75?"B":avg>=50?"C":"D";
    }
}

public class Main1 {
    public static void main(String[] args){
        Student st=new Student("John");
        st.addSub(new Subject("Maths",90));
        st.addSub(new Subject("Science",85));
        GradeCalculator g=new GradeCalculator();
        System.out.println(st.name+" Grade: "+g.calc(st));
    }
}
