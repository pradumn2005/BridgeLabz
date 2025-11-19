import java.util.Scanner;

public class B3_NthFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        
        if (n <= 0) {
            System.out.println(0);
            return;
        }
        if (n == 1) {
            System.out.println(1);
            return;
        }

        long a = 0;
        long b = 1;
        long result = 0;
        
        for (int i = 2; i <= n; i++) {
            result = a + b;
            a = b;
            b = result;
        }
        
        System.out.println(result);
    }
}
