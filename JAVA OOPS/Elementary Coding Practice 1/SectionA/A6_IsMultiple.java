import java.util.Scanner;

public class A6_IsMultiple {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        
        if (m == 0) {
            System.out.println("Cannot divide by zero.");
        } else if (n % m == 0) {
            System.out.println(n + " is an exact multiple of " + m);
        } else {
            System.out.println(n + " is NOT an exact multiple of " + m);
        }
    }
}
