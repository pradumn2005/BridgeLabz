abstract class Employee {
    private int employeeId;
    private String name;
    private double baseSalary;
    public Employee(int id, String name, double baseSalary) {
        this.employeeId=id; this.name=name; this.baseSalary=baseSalary;
    }
    public int getEmployeeId() { return employeeId; }
    public String getName() { return name; }
    public double getBaseSalary() { return baseSalary; }
    public abstract double calculateSalary();
    public void displayDetails() {
        System.out.println(employeeId+" "+name+" "+calculateSalary());
    }
}

interface Department {
    void assignDepartment(String d);
    String getDepartmentDetails();
}

class FullTimeEmployee extends Employee implements Department {
    private String dept;
    public FullTimeEmployee(int id, String name, double baseSalary) {
        super(id,name,baseSalary);
    }
    public double calculateSalary() { return getBaseSalary(); }
    public void assignDepartment(String d) { dept=d; }
    public String getDepartmentDetails() { return dept; }
}

class PartTimeEmployee extends Employee implements Department {
    private String dept; private int hours; private double rate;
    public PartTimeEmployee(int id,String name,double baseSalary,int h,double r) {
        super(id,name,baseSalary); hours=h; rate=r;
    }
    public double calculateSalary() { return hours*rate; }
    public void assignDepartment(String d) { dept=d; }
    public String getDepartmentDetails() { return dept; }
}

public class Main1 {
    public static void main(String[] args) {
        Employee e1=new FullTimeEmployee(1,"Raj",50000);
        Employee e2=new PartTimeEmployee(2,"Sam",0,40,200);
        e1.displayDetails(); e2.displayDetails();
    }
}
