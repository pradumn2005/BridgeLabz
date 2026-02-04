public class ArraySum {
    public static int sumArray(int[] arr, int n) {
        if (n <= 0) {
            return 0;
        }
        return arr[n - 1] + sumArray(arr, n - 1);
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 8, 10};
        int result = sumArray(arr, arr.length);
        System.out.println("Sum of array elements: " + result);
    }
}
