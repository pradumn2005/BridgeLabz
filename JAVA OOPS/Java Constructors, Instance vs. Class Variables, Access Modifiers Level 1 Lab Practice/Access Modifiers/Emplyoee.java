class Employee {
    public int employeeID;
    protected String department;
    private double salary;
    Employee(int id, String d, double s) {
        employeeID = id;
        department = d;
        salary = s;
    }
    public void setSalary(double s) {
        salary = s;
    }
    public double getSalary() {
        return salary;
    }
}
class Manager extends Employee {
    String team;
    Manager(int id, String d, double s, String t) {
        super(id, d, s);
        team = t;
    }
    void display() {
        System.out.println("Employee ID: " + employeeID);
        System.out.println("Department: " + department);
        System.out.println("Salary: " + getSalary());
        System.out.println("Team: " + team);
    }
    public static void main(String[] args) {
        Manager m = new Manager(201, "IT", 75000, "Dev Team");
        m.display();
        m.setSalary(80000);
        System.out.println("Updated Salary: " + m.getSalary());
    }
}
