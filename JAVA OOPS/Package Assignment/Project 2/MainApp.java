import com.university.department.cse.Course;

public class MainApp {
    public static void main(String[] args) {
        Course c1 = new Course("Data Structures", "CSE201", 4);

        System.out.println("--- Course Details ---");
        c1.displayCourseDetails();
    }
}
