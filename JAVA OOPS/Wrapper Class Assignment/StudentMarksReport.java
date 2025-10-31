import java.util.ArrayList;
import java.util.List;

public class StudentMarksReport {
    public static void main(String[] args) {
        Object[] marks = {"85", 95, Integer.valueOf(88), "null", "abc", null, 78};
        List<Integer> validMarks = new ArrayList<>();
        
        for (Object mark : marks) {
            if (mark == null) {
                continue;
            }
            
            try {
                int validMark = Integer.parseInt(mark.toString());
                validMarks.add(validMark);
            } catch (NumberFormatException e) {
                // Ignore invalid formats like "abc" or "null" string
            }
        }

        double sum = 0;
        for (int mark : validMarks) {
            sum += mark;
        }
        
        double average = sum / validMarks.size();

        System.out.println("Valid marks: " + validMarks);
        System.out.println("Average of valid marks: " + average);
    }
}
