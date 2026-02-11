import java.util.Scanner;

public class RotationPointBinary {
    public static int findRotationPoint(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] > arr[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return arr[left];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] arr = new int[size];
        
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }
        
        int result = findRotationPoint(arr);
        System.out.println(result);
        scanner.close();
    }
}
