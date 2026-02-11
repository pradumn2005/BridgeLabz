import java.util.Scanner;
import java.util.Arrays;

public class BubbleSortMarks {
    public static void bubbleSort(int[] marks) {
        int n = marks.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (marks[j] > marks[j + 1]) {
                    int temp = marks[j];
                    marks[j] = marks[j + 1];
                    marks[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int count = scanner.nextInt();
        int[] marks = new int[count];
        for (int i = 0; i < count; i++) {
            System.out.print("Enter mark for student " + (i + 1) + ": ");
            marks[i] = scanner.nextInt();
        }
        bubbleSort(marks);
        System.out.println("Sorted Marks: " + Arrays.toString(marks));
        scanner.close();
    }
}
