class TaskNode {
    int taskId;
    String taskName;
    int priority;
    String dueDate;
    TaskNode next;

    public TaskNode(int id, String name, int prio, String date) {
        this.taskId = id;
        this.taskName = name;
        this.priority = prio;
        this.dueDate = date;
    }
}

public class TaskScheduler {
    TaskNode head;
    TaskNode tail;
    TaskNode current;

    public void addTask(int id, String name, int prio, String date) {
        TaskNode newNode = new TaskNode(id, name, prio, date);
        if (head == null) {
            head = newNode;
            tail = newNode;
            newNode.next = head;
            current = head;
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
    }

    public void removeTask(int id) {
        if (head == null) return;
        TaskNode curr = head;
        TaskNode prev = tail;
        
        do {
            if (curr.taskId == id) {
                if (curr == head && curr == tail) {
                    head = null;
                    tail = null;
                    current = null;
                } else {
                    if (curr == head) head = head.next;
                    if (curr == tail) tail = prev;
                    prev.next = curr.next;
                }
                return;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != head);
    }

    public void viewNextTask() {
        if (current != null) {
            System.out.println("Current Task: " + current.taskName);
            current = current.next;
        }
    }

    public void displayAll() {
        if (head == null) return;
        TaskNode temp = head;
        do {
            System.out.println("ID: " + temp.taskId + " Name: " + temp.taskName);
            temp = temp.next;
        } while (temp != head);
    }

    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();
        scheduler.addTask(1, "Fix Bug", 1, "Monday");
        scheduler.addTask(2, "Write Docs", 2, "Tuesday");
        scheduler.displayAll();
        scheduler.viewNextTask();
        scheduler.viewNextTask();
        scheduler.removeTask(1);
        scheduler.displayAll();
    }
}
