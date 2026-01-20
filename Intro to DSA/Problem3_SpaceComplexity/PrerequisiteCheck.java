import java.util.HashSet;

public class PrerequisiteCheck {
    public static void main(String[] args) {
        int[] completedCourses = {101, 102, 201, 205};
        int[] prerequisites = {101, 201};
        
        System.out.println("Implementation A (Nested): " + 
            hasCompletedAllPrerequisitesNested(completedCourses, prerequisites));
            
        System.out.println("Implementation B (HashSet): " + 
            hasCompletedAllPrerequisitesHashSet(completedCourses, prerequisites));
    }

    // Implementation A: Nested Loop (Space-Efficient)
    public static boolean hasCompletedAllPrerequisitesNested(int[] completedCourses, int[] prerequisites) {
        int n = completedCourses.length;
        int m = prerequisites.length;
        
        for (int i = 0; i < m; i++) {
            boolean found = false;
            for (int j = 0; j < n; j++) {
                if (prerequisites[i] == completedCourses[j]) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                return false;
            }
        }
        return true;
    }

    // Implementation B: Hash Set (Time-Efficient)
    public static boolean hasCompletedAllPrerequisitesHashSet(int[] completedCourses, int[] prerequisites) {
        HashSet<Integer> completedSet = new HashSet<>();
        
        for (int course : completedCourses) {
            completedSet.add(course);
        }
        
        for (int required : prerequisites) {
            if (!completedSet.contains(required)) {
                return false;
            }
        }
        return true;
    }
}
