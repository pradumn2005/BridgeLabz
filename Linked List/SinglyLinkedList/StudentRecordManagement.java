import java.util.Scanner;

class StudentNode {
    int rollNumber;
    String name;
    int age;
    char grade;
    StudentNode next;

    public StudentNode(int rollNumber, String name, int age, char grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

public class StudentRecordManagement {
    StudentNode head;

    public void addAtBeginning(int roll, String name, int age, char grade) {
        StudentNode newNode = new StudentNode(roll, name, age, grade);
        newNode.next = head;
        head = newNode;
    }

    public void addAtEnd(int roll, String name, int age, char grade) {
        StudentNode newNode = new StudentNode(roll, name, age, grade);
        if (head == null) {
            head = newNode;
            return;
        }
        StudentNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    public void deleteByRoll(int roll) {
        if (head == null) return;
        if (head.rollNumber == roll) {
            head = head.next;
            return;
        }
        StudentNode temp = head;
        while (temp.next != null && temp.next.rollNumber != roll) {
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }

    public void searchByRoll(int roll) {
        StudentNode temp = head;
        while (temp != null) {
            if (temp.rollNumber == roll) {
                System.out.println("Found: " + temp.name);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student not found.");
    }

    public void updateGrade(int roll, char newGrade) {
        StudentNode temp = head;
        while (temp != null) {
            if (temp.rollNumber == roll) {
                temp.grade = newGrade;
                return;
            }
            temp = temp.next;
        }
    }

    public void displayAll() {
        StudentNode temp = head;
        while (temp != null) {
            System.out.println(temp.rollNumber + " " + temp.name + " " + temp.grade);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        StudentRecordManagement list = new StudentRecordManagement();
        list.addAtEnd(101, "Alice", 20, 'A');
        list.addAtEnd(102, "Bob", 21, 'B');
        list.displayAll();
        list.updateGrade(102, 'A');
        list.deleteByRoll(101);
        list.displayAll();
    }
}
