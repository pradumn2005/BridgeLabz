import java.util.*;

class Faculty {
    String name;
    Faculty(String n){ name=n; }
    public String toString(){ return name; }
}

class Department {
    String name;
    Department(String n){ name=n; }
    public String toString(){ return name; }
}

class University {
    String name;
    ArrayList<Department> depts=new ArrayList<>();
    University(String n){ name=n; }
    void addDept(Department d){ depts.add(d); }
    void show(){ System.out.println(name+" has depts: "+depts); }
}

public class Main2 {
    public static void main(String[] args){
        University u=new University("XYZ University");
        Department d1=new Department("CS"); Department d2=new Department("Math");
        u.addDept(d1); u.addDept(d2);
        Faculty f1=new Faculty("Dr. Mehta"); Faculty f2=new Faculty("Dr. Roy");
        u.show(); System.out.println("Independent Faculty: "+f1+", "+f2);
    }
}
