import java.util.*;

class NumberCheck {
    public static boolean isPositive(int n) {
        return n > 0;
    }

    public static boolean isEven(int n) {
        return n % 2 == 0;
    }

    public static int compare(int a, int b) {
        if (a > b) return 1;
        if (a == b) return 0;
        return -1;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[5];
        for (int i = 0; i < 5; i++) {
            arr[i] = sc.nextInt();
            if (isPositive(arr[i])) {
                if (isEven(arr[i])) System.out.println(arr[i] + " is Positive and Even");
                else System.out.println(arr[i] + " is Positive and Odd");
            } else {
                System.out.println(arr[i] + " is Negative");
            }
        }
        int cmp = compare(arr[0], arr[4]);
        if (cmp == 0) System.out.println("First and Last are Equal");
        else if (cmp > 0) System.out.println("First is Greater");
        else System.out.println("First is Smaller");
    }
}
