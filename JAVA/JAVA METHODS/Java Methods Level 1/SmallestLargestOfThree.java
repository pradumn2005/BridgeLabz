import java.util.*;

class SmallestLargestOfThree {
    public static int[] findSmallestAndLargest(int a, int b, int c) {
        int min = a, max = a;
        if (b < min) min = b;
        if (c < min) min = c;
        if (b > max) max = b;
        if (c > max) max = c;
        return new int[]{min, max};
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
        int ans[] = findSmallestAndLargest(a, b, c);
        System.out.println("Smallest: " + ans[0] + ", Largest: " + ans[1]);
    }
}
