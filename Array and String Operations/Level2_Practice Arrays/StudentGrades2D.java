import java.util.Scanner;

public class StudentGrades2D {
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
        
        // Declare 2D array for marks. Columns: 0=Physics, 1=Chemistry, 2=Maths
        int numSubjects = 3;
        double[][] marks = new double[numStudents][numSubjects];
        
        // Declare arrays for percentages and grades
        double[] percentages = new double[numStudents];
        char[] grades = new char[numStudents];
        
        // Define total max marks
        double totalMaxMarks = 300.0;
        
        // Loop to populate 2D array and compute results
        for (int i = 0; i < marks.length; i++) {
            // Prompt for marks
            System.out.print("Enter Physics marks for student " + (i + 1) + ": ");
            double p = input.nextDouble();
            
            System.out.print("Enter Chemistry marks for student " + (i + 1) + ": ");
            double c = input.nextDouble();
            
            System.out.print("Enter Maths marks for student " + (i + 1) + ": ");
            double m = input.nextDouble();
            
            // Validate marks
            if (p < 0 || c < 0 || m < 0 || p > 100 || c > 100 || m > 100) {
                System.out.println("Invalid marks entered. Must be 0-100.");
                // Decrement index to ask again
                i--;
                continue;
            }
            
            // Store valid marks in 2D array
            marks[i][0] = p;
            marks[i][1] = c;
            marks[i][2] = m;
            
            // Compute percentage
            double totalObtained = marks[i][0] + marks[i][1] + marks[i][2];
            percentages[i] = (totalObtained / totalMaxMarks) * 100;
            
            // Assign grade
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
        for (int i = 0; i < marks.length; i++) {
            System.out.println("Student " + (i + 1) + " | Physics: " + marks[i][0] + " | Chemistry: " + marks[i][1] + " | Maths: " + marks[i][2] + " | Percentage: " + percentages[i] + "% | Grade: " + grades[i]);
        }
        
        // Close scanner
        input.close();
    }
}
