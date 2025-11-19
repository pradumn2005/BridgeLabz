import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Tracks student registration per course using Map<String, Integer>
 * for course code -> number of students.
 */
public class CourseRegistrationSystem {

    private Map<String, Integer> registrationCounts = new HashMap<>();

    // 1. Add courses with initial registration counts.
    public void addCourse(String courseCode, int initialCount) {
        registrationCounts.put(courseCode, initialCount);
    }

    // 2. Add or drop students
    public void changeRegistration(String courseCode, int change) {
        if (!registrationCounts.containsKey(courseCode)) {
            System.out.println("Error: Course " + courseCode + " not found.");
            return;
        }

        // Use compute to ensure the count is not negative
        registrationCounts.compute(courseCode, (code, currentCount) -> {
            int newCount = currentCount + change;
            if (newCount < 0) {
                System.out.println("Warning: Cannot drop students below zero for " + code + ". Count remains 0.");
                return 0; // Set to 0 if resulting count is negative
            }
            return newCount;
        });
        System.out.println(courseCode + " count updated. New count: " + registrationCounts.get(courseCode));
    }

    // 3. Print a list of courses that are near full and under-subscribed.
    public void printCourseReport(int nearFullThreshold, int underSubscribedThreshold) {
        System.out.println("\n--- Course Registration Report ---");

        List<String> nearFull = registrationCounts.entrySet().stream()
            .filter(entry -> entry.getValue() >= nearFullThreshold)
            .map(entry -> entry.getKey() + " (" + entry.getValue() + " students)")
            .collect(Collectors.toList());

        List<String> underSubscribed = registrationCounts.entrySet().stream()
            .filter(entry -> entry.getValue() < underSubscribedThreshold)
            .map(entry -> entry.getKey() + " (" + entry.getValue() + " students)")
            .collect(Collectors.toList());

        System.out.println("\nCourses Near Full (>= " + nearFullThreshold + "):");
        if (nearFull.isEmpty()) System.out.println("None.");
        nearFull.forEach(System.out::println);

        System.out.println("\nCourses Under-Subscribed (< " + underSubscribedThreshold + "):");
        if (underSubscribed.isEmpty()) System.out.println("None.");
        underSubscribed.forEach(System.out::println);
    }

    public static void main(String[] args) {
        CourseRegistrationSystem system = new CourseRegistrationSystem();

        // 1. Add courses with initial counts
        system.addCourse("CS101", 48); // Near Full
        system.addCourse("MA202", 2);  // Under-Subscribed
        system.addCourse("PH303", 15);
        system.addCourse("AR100", 50); // Near Full
        system.addCourse("EC400", 0);  // Under-Subscribed

        // 2. Add or drop students
        System.out.println("--- Registration Changes ---");
        system.changeRegistration("CS101", 3);  // Add 3 -> 51
        system.changeRegistration("MA202", -3); // Drop 3 -> should be 0 (handles negative count)
        system.changeRegistration("PH303", 10); // Add 10 -> 25

        // 3. Print report
        system.printCourseReport(50, 5);
    }
}
