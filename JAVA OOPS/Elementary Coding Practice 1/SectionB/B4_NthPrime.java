import java.util.Scanner;

public class B4_NthPrime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        
        int count = 0;
        int num = 1;
        int nthPrime = 0;
        
        while (count < n) {
            num++;
            if (isPrime(num)) {
                count++;
                nthPrime = num;
            }
        }
        
        System.out.println(nthPrime);
    }
    
    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
