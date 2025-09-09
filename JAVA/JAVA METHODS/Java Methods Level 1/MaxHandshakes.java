import java.util.*;

class MaxHandshakes {
    static long handshakes(int n) {
        return (long) n * (n - 1) / 2;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int students = sc.nextInt();
        System.out.println(handshakes(students));
    }
}
