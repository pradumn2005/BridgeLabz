import java.util.Scanner;

public class StudentGrades1D {
    public static void main(String[] args) {
        // Declare scanner for user input
        Scanner input = new Scanner(System.in);
        
        // Prompt for number of students
        System.out.print("Enter number of students: ");
        int numStudents = input.nextInt();
        
        // Validate user input
        if (numStudents <= 0) {
            System.out.println("Invalid number of students. Exiting program.");
            System.exit(0);
        }
        
        // Declare arrays for marks, percentages, and grades
        double[] physics = new double[numStudents];
        double[] chemistry = new double[numStudents];
        double[] maths = new double[numStudents];
        double[] percentages = new double[numStudents];
        char[] grades = new char[numStudents];
        
        // Define fixed total marks per subject
        double maxMarksPerSubject = 100.0;
        double totalMaxMarks = maxMarksPerSubject * 3;
        
        // Loop to get marks and compute results
        for (int i = 0; i < physics.length; i++) {
            // Prompt for physics marks
            System.out.print("Enter Physics marks for student " + (i + 1) + ": ");
            double p = input.nextDouble();
            
            // Prompt for chemistry marks
            System.out.print("Enter Chemistry marks for student " + (i + 1) + ": ");
            double c = input.nextDouble();
            
            // Prompt for maths marks
            System.out.print("Enter Maths marks for student " + (i + 1) + ": ");
            double m = input.nextDouble();
            
            // Validate input marks
            if (p < 0 || c < 0 || m < 0 || p > 100 || c > 100 || m > 100) {
                System.out.println("Invalid marks entered. Marks must be between 0 and 100.");
                // Decrement index to re-enter data
                i--;
                continue;
            }
            
            // Store validated marks
            physics[i] = p;
            chemistry[i] = c;
            maths[i] = m;
            
            // Calculate percentage
            double totalObtained = physics[i] + chemistry[i] + maths[i];
            percentages[i] = (totalObtained / totalMaxMarks) * 100;
            
            // Determine grade based on percentage
            if (percentages[i] >= 80) {
                grades[i] = 'A';
            } else if (percentages[i] >= 60) {
                grades[i] = 'B';
            } else if (percentages[i] >= 40) {
                grades[i] = 'C';
            } else {
                grades[i] = 'D';
            }
        }
        
        // Display the results
        System.out.println("\n--- Student Results ---");
        for (int i = 0; i < physics.length; i++) {
            System.out.println("Student " + (i + 1) + " | Physics: " + physics[i] + " | Chemistry: " + chemistry[i] + " | Maths: " + maths[i] + " | Percentage: " + percentages[i] + "% | Grade: " + grades[i]);
        }
        
        // Close scanner
        input.close();
    }
}
