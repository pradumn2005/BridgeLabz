import java.util.Scanner;

public class StudentScorecard {
    public static int[][] generateScores(int numStudents) {
        int[][] scores = new int[numStudents][3];
        for (int i = 0; i < numStudents; i++) {
            for (int j = 0; j < 3; j++) {
                scores[i][j] = (int)(Math.random() * 61) + 40; 
            }
        }
        return scores;
    }

    public static double[][] calculateMetrics(int[][] scores) {
        double[][] metrics = new double[scores.length][3];
        for (int i = 0; i < scores.length; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double average = total / 3.0;
            double percentage = (total / 300.0) * 100;

            metrics[i][0] = Math.round(total * 100.0) / 100.0;
            metrics[i][1] = Math.round(average * 100.0) / 100.0;
            metrics[i][2] = Math.round(percentage * 100.0) / 100.0;
        }
        return metrics;
    }

    public static String[] calculateGrades(double[][] metrics) {
        String[] grades = new String[metrics.length];
        for (int i = 0; i < metrics.length; i++) {
            double percentage = metrics[i][2];
            if (percentage >= 80) {
                grades[i] = "A";
            } else if (percentage >= 60) {
                grades[i] = "B";
            } else if (percentage >= 40) {
                grades[i] = "C";
            } else {
                grades[i] = "D";
            }
        }
        return grades;
    }

    public static void displayScorecard(int[][] scores, double[][] metrics, String[] grades) {
        System.out.println(String.format("%-10s | %-5s | %-5s | %-5s | %-7s | %-7s | %-10s | %-5s", 
                "Student", "Phy", "Chem", "Math", "Total", "Avg", "Percent", "Grade"));
        System.out.println("--------------------------------------------------------------------------------");
        for (int i = 0; i < scores.length; i++) {
            System.out.println(String.format("%-10s | %-5d | %-5d | %-5d | %-7.2f | %-7.2f | %-10.2f | %-5s", 
                    "Std " + (i + 1), scores[i][0], scores[i][1], scores[i][2], 
                    metrics[i][0], metrics[i][1], metrics[i][2], grades[i]));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int numStudents = 0;

        try {
            numStudents = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Invalid input.");
            System.exit(1);
        }

        if (numStudents <= 0) {
            System.out.println("Number of students must be positive.");
            System.exit(1);
        }

        int[][] scores = generateScores(numStudents);
        double[][] metrics = calculateMetrics(scores);
        String[] grades = calculateGrades(metrics);

        displayScorecard(scores, metrics, grades);
        
        scanner.close();
    }
}
