import java.util.Scanner;
import java.util.Arrays;

public class InsertionSortEmployeeIds {
    public static void insertionSort(int[] ids) {
        for (int i = 1; i < ids.length; i++) {
            int key = ids[i];
            int j = i - 1;
            while (j >= 0 && ids[j] > key) {
                ids[j + 1] = ids[j];
                j = j - 1;
            }
            ids[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of employees: ");
        int count = scanner.nextInt();
        int[] ids = new int[count];
        for (int i = 0; i < count; i++) {
            System.out.print("Enter ID for employee " + (i + 1) + ": ");
            ids[i] = scanner.nextInt();
        }
        insertionSort(ids);
        System.out.println("Sorted Employee IDs: " + Arrays.toString(ids));
        scanner.close();
    }
}
