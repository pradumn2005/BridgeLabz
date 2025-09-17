class Employee {
    private static String companyName = "TechCorp";
    private static int totalEmployees = 0;

    private final int id;
    private String name;
    private String designation;

    Employee(int id, String name, String designation) {
        this.id = id;
        this.name = name;
        this.designation = designation;
        totalEmployees++;
    }

    public static void displayTotalEmployees() {
        System.out.println("Total Employees: " + totalEmployees);
    }

    void display() {
        if (this instanceof Employee) {
            System.out.println("Company: " + companyName);
            System.out.println("ID: " + id);
            System.out.println("Name: " + name);
            System.out.println("Designation: " + designation);
        }
    }

    public static void main(String[] args) {
        Employee e1 = new Employee(101, "Neha", "Developer");
        Employee e2 = new Employee(102, "Karan", "Tester");
        e1.display();
        e2.display();
        Employee.displayTotalEmployees();
    }
}
