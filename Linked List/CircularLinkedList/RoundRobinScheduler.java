class ProcessNode {
    int pid;
    int burstTime;
    int priority;
    ProcessNode next;

    public ProcessNode(int pid, int burst, int priority) {
        this.pid = pid;
        this.burstTime = burst;
        this.priority = priority;
    }
}

public class RoundRobinScheduler {
    ProcessNode head;
    ProcessNode tail;

    public void addProcess(int pid, int burst, int priority) {
        ProcessNode newNode = new ProcessNode(pid, burst, priority);
        if (head == null) {
            head = newNode;
            tail = newNode;
            newNode.next = head;
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
    }

    public void removeProcess(int pid) {
        if (head == null) return;
        ProcessNode curr = head;
        ProcessNode prev = tail;
        
        do {
            if (curr.pid == pid) {
                if (curr == head && curr == tail) {
                    head = null;
                    tail = null;
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

    public void simulate(int timeQuantum) {
        if (head == null) return;
        ProcessNode curr = head;
        System.out.println("Starting Simulation...");
        while (head != null) {
            System.out.println("Executing PID: " + curr.pid + " Remaining: " + curr.burstTime);
            curr.burstTime -= timeQuantum;
            
            ProcessNode nextNode = curr.next; 
            
            if (curr.burstTime <= 0) {
                System.out.println("Process " + curr.pid + " Completed.");
                removeProcess(curr.pid);
                if (head == null) break;
            }
            curr = nextNode;
            
             // If node was removed, ensure we are pointing to valid next
             if (head != null && curr.pid == 0) curr = head; 
        }
        System.out.println("All processes finished.");
    }

    public static void main(String[] args) {
        RoundRobinScheduler rr = new RoundRobinScheduler();
        rr.addProcess(1, 10, 1);
        rr.addProcess(2, 5, 2);
        rr.addProcess(3, 8, 1);
        rr.simulate(4);
    }
}
