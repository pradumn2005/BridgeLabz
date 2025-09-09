import java.util.*;

class RemainderQuotient {
    public static int[] findRemainderAndQuotient(int number, int divisor) {
        int rem = number % divisor;
        int quo = number / divisor;
        return new int[]{rem, quo};
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int divisor = sc.nextInt();
        int ans[] = findRemainderAndQuotient(number, divisor);
        System.out.println("Remainder: " + ans[0] + ", Quotient: " + ans[1]);
    }
}
