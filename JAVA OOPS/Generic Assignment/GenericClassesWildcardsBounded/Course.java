import java.util.List;
import java.util.ArrayList;

public class Course<T extends CourseType> {

    private String courseName;
    private T type;

    public Course(String courseName, T type) {
        this.courseName = courseName;
        this.type = type;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getEvaluationType() {
        return type.getEvaluationType();
    }

    public static void displayAllCourses(List<? extends Course<?>> courses) {
        System.out.println("--- University Course Catalog ---");
        for (Course<?> course : courses) {
            System.out.println(course.getCourseName() + " (" + course.getEvaluationType() + ")");
        }
        System.out.println("---------------------------------");
    }

    public static void main(String[] args) {
        Course<ExamCourse> mathCourse = new Course<>("Calculus I", new ExamCourse());
        Course<AssignmentCourse> csCourse = new Course<>("Data Structures", new AssignmentCourse());
        Course<ResearchCourse> phdCourse = new Course<>("Advanced Topic", new ResearchCourse());

        List<Course<ExamCourse>> examCourses = List.of(mathCourse, new Course<>("Physics", new ExamCourse()));
        List<Course<AssignmentCourse>> assignmentCourses = List.of(csCourse);
        List<Course<?>> allCourses = new ArrayList<>();
        allCourses.add(mathCourse);
        allCourses.add(csCourse);
        allCourses.add(phdCourse);

        System.out.println("Exam Courses:");
        for (Course<?> course : examCourses) {
             System.out.println(course.getCourseName() + " is " + course.getEvaluationType());
        }

        System.out.println("\nAll Courses in Catalog:");
        displayAllCourses(allCourses);
    }
}
