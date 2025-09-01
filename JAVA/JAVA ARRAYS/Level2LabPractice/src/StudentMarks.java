import java.util.Scanner;

public class StudentMarks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of students:");
        int n = sc.nextInt();

        double[][] marks = new double[n][3];
        double[] percentage = new double[n];
        String[] grade = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter marks of student " + (i + 1) + " in Physics, Chemistry, Maths:");
            for (int j = 0; j < 3; j++) {
                double m;
                while (true) {
                    m = sc.nextDouble();
                    if (m >= 0 && m <= 100) break;
                    System.out.println("Invalid marks. Enter again:");
                }
                marks[i][j] = m;
            }
            double total = marks[i][0] + marks[i][1] + marks[i][2];
            percentage[i] = total / 3;
            if (percentage[i] >= 90) grade[i] = "A";
            else if (percentage[i] >= 75) grade[i] = "B";
            else if (percentage[i] >= 50) grade[i] = "C";
            else grade[i] = "D";
        }

        System.out.println("\nPhysics\tChemistry\tMaths\tPercentage\tGrade");
        for (int i = 0; i < n; i++) {
            System.out.printf("%.1f\t%.1f\t\t%.1f\t%.2f\t\t%s\n",
                    marks[i][0], marks[i][1], marks[i][2], percentage[i], grade[i]);
        }

        sc.close();
    }
}
