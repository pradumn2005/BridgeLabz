class Employee {
    String name;
    int id;
    double salary;
    void displayDetails() {
        System.out.println(name + " " + id + " " + salary);
    }
}

class Manager extends Employee {
    int teamSize;
    void displayDetails() {
        System.out.println(name + " " + id + " " + salary + " " + teamSize);
    }
}

class Developer extends Employee {
    String programmingLanguage;
    void displayDetails() {
        System.out.println(name + " " + id + " " + salary + " " + programmingLanguage);
    }
}

class Intern extends Employee {
    String duration;
    void displayDetails() {
        System.out.println(name + " " + id + " " + salary + " " + duration);
    }
}

public class Main2 {
    public static void main(String[] args) {
        Manager m = new Manager();
        m.name="Raj"; m.id=1; m.salary=50000; m.teamSize=5;
        m.displayDetails();
    }
}
