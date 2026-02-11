import java.util.Scanner;

public class FirstLastOccurrence {
    public static int findFirst(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int result = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                result = mid;
                right = mid - 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    public static int findLast(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int result = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                result = mid;
                left = mid + 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    public static int[] findOccurrences(int[] arr, int target) {
        int first = findFirst(arr, target);
        int last = findLast(arr, target);
        return new int[]{first, last};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] arr = new int[size];
        
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }
        
        int target = scanner.nextInt();
        int[] result = findOccurrences(arr, target);
        System.out.println(result[0]);
        System.out.println(result[1]);
        scanner.close();
    }
}
