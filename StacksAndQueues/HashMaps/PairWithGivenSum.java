import java.util.HashSet;

public class PairWithGivenSum {
    public static boolean hasPairWithSum(int[] arr, int sum) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : arr) {
            if (set.contains(sum - num)) {
                System.out.println("Pair found: " + num + " and " + (sum - num));
                return true;
            }
            set.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {0, -1, 2, -3, 1};
        int sum = -2;
        hasPairWithSum(arr, sum);
    }
}
