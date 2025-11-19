public class MaximumFinder {

    public static <T extends Comparable<T>> T maximum(T x, T y, T z) {
        T max = x;
        if (y.compareTo(max) > 0) {
            max = y;
        }
        if (z.compareTo(max) > 0) {
            max = z;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println("Maximum of 5, 2, 8 is: " + maximum(5, 2, 8));
        System.out.println("Maximum of 'apple', 'banana', 'cherry' is: " + maximum("apple", "banana", "cherry"));
        System.out.println("Maximum of 3.14, 1.61, 2.71 is: " + maximum(3.14, 1.61, 2.71));
    }
}
