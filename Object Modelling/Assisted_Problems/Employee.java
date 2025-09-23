import java.util.*;

class Employee {
    String name;
    Employee(String n){ name=n; }
    public String toString(){ return name; }
}

class Department {
    String name;
    ArrayList<Employee> emps=new ArrayList<>();
    Department(String n){ name=n; }
    void addEmp(Employee e){ emps.add(e); }
    void show(){ System.out.println(name+" Dept: "+emps); }
}

class Company {
    String name;
    ArrayList<Department> deps=new ArrayList<>();
    Company(String n){ name=n; }
    void addDept(Department d){ deps.add(d); }
    void show(){ for(Department d:deps) d.show(); }
}

public class Main3 {
    public static void main(String[] args){
        Company c=new Company("TechCorp");
        Department d1=new Department("HR");
        d1.addEmp(new Employee("Alice"));
        c.addDept(d1);
        c.show();
        // If 'c' is deleted, all depts & emps are gone
    }
}
