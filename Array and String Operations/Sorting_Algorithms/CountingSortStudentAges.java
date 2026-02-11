import java.util.Scanner;
import java.util.Arrays;

public class CountingSortStudentAges {
    public static void countingSort(int[] ages) {
        int max = ages[0];
        int min = ages[0];
        for (int i = 1; i < ages.length; i++) {
            if (ages[i] > max) max = ages[i];
            if (ages[i] < min) min = ages[i];
        }
        int range = max - min + 1;
        int[] count = new int[range];
        int[] output = new int[ages.length];
        
        for (int i = 0; i < ages.length; i++) {
            count[ages[i] - min]++;
        }
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
        for (int i = ages.length - 1; i >= 0; i--) {
            output[count[ages[i] - min] - 1] = ages[i];
            count[ages[i] - min]--;
        }
        for (int i = 0; i < ages.length; i++) {
            ages[i] = output[i];
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int count = scanner.nextInt();
        int[] ages = new int[count];
        for (int i = 0; i < count; i++) {
            System.out.print("Enter age for student " + (i + 1) + ": ");
            ages[i] = scanner.nextInt();
        }
        countingSort(ages);
        System.out.println("Sorted Student Ages: " + Arrays.toString(ages));
        scanner.close();
    }
}
