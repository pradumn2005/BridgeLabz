import java.util.*;

class ChocolateDivision {
    public static int[] findRemainderAndQuotient(int number, int divisor) {
        int rem = number % divisor;
        int quo = number / divisor;
        return new int[]{rem, quo};
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int chocolates = sc.nextInt();
        int children = sc.nextInt();
        int ans[] = findRemainderAndQuotient(chocolates, children);
        System.out.println("Each child gets: " + ans[1]);
        System.out.println("Remaining chocolates: " + ans[0]);
    }
}
