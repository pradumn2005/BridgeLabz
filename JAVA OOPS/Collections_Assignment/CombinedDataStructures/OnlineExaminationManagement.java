import java.util.*;

/**
 * Online Examination Management System demonstrating List, Set, Queue, and Stack.
 */
class Question {
    String id;
    String text;
    public Question(String id, String text) { this.id = id; this.text = text; }
    @Override public String toString() { return "Q:" + id; }
}
class Student {
    String studentId;
    public Student(String studentId) { this.studentId = studentId; }
    @Override public String toString() { return "ID:" + studentId; }
    // equals/hashCode based on studentId for Set usage
    @Override public boolean equals(Object o) { if (this == o) return true; if (o == null || getClass() != o.getClass()) return false; Student student = (Student) o; return studentId.equals(student.studentId); }
    @Override public int hashCode() { return studentId.hashCode(); }
}

public class OnlineExaminationManagement {
    private List<Question> allQuestions = new ArrayList<>();
    private Set<String> enrolledStudentIds = new HashSet<>();
    private Queue<Student> waitingQueue = new LinkedList<>();

    // 1. Enroll students and ensure no duplicate IDs.
    public boolean enrollStudent(Student student) {
        if (enrolledStudentIds.add(student.studentId)) {
            System.out.println("-> Enrolled student: " + student);
            return true;
        } else {
            System.out.println("! Student ID already enrolled: " + student);
            return false;
        }
    }

    // 2. Add and randomize exam questions.
    public void addQuestions(List<Question> questions) {
        allQuestions.addAll(questions);
        Collections.shuffle(allQuestions);
        System.out.println("Total questions added and shuffled: " + allQuestions.size());
    }

    // 3. Serve students in order of queue.
    public void addToQueue(Student student) {
        if (enrolledStudentIds.contains(student.studentId)) {
            waitingQueue.add(student);
            System.out.println("-> Student " + student.studentId + " added to waiting queue.");
        }
    }

    public void serveNextStudent() {
        Student student = waitingQueue.poll();
        if (student != null) {
            System.out.println("\n--- Serving Next Student: " + student + " ---");
            // 4. Allow students to navigate between questions using a stack.
            Stack<Question> questionStack = new Stack<>();
            for (Question q : allQuestions) {
                questionStack.push(q);
            }
            navigateExam(student, questionStack);
        } else {
            System.out.println("\nNo students currently waiting.");
        }
    }

    public void navigateExam(Student student, Stack<Question> stack) {
        System.out.println("Starting exam for " + student);
        while (!stack.isEmpty()) {
            Question current = stack.pop();
            System.out.println("  Viewing " + current + ". (Stack size: " + stack.size() + ")");
            // Simulate answering or going back
            if (stack.size() % 2 == 0) {
                 // Push current question back onto stack to simulate 'back' functionality
                 // A real system would use a history stack and a future stack, this is simplified.
                 // System.out.println("    Simulating 'Back' to question " + current);
                 // stack.push(current); // Simple implementation of 'back' using a single stack
            }
        }
        System.out.println("Student " + student.studentId + " finished exam.");
    }

    public static void main(String[] args) {
        OnlineExaminationManagement system = new OnlineExaminationManagement();

        // 1. Enroll students
        Student s1 = new Student("S100");
        Student s2 = new Student("S200");
        Student s3 = new Student("S100"); // Duplicate

        system.enrollStudent(s1);
        system.enrollStudent(s2);
        system.enrollStudent(s3);

        // 2. Add questions
        system.addQuestions(List.of(
            new Question("Q1", "..."), new Question("Q2", "..."),
            new Question("Q3", "..."), new Question("Q4", "...")
        ));

        // 3. Serve students in order
        system.addToQueue(s1);
        system.addToQueue(s2);

        system.serveNextStudent();
        system.serveNextStudent();
    }
}
