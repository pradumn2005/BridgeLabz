import java.util.Scanner;
import java.util.Arrays;

public class SelectionSortExamScores {
    public static void selectionSort(double[] scores) {
        int n = scores.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (scores[j] < scores[minIndex]) {
                    minIndex = j;
                }
            }
            double temp = scores[minIndex];
            scores[minIndex] = scores[i];
            scores[i] = temp;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of exams: ");
        int count = scanner.nextInt();
        double[] scores = new double[count];
        for (int i = 0; i < count; i++) {
            System.out.print("Enter score " + (i + 1) + ": ");
            scores[i] = scanner.nextDouble();
        }
        selectionSort(scores);
        System.out.println("Sorted Exam Scores: " + Arrays.toString(scores));
        scanner.close();
    }
}
