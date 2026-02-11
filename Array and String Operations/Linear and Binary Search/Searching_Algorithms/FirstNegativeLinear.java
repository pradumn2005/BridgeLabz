import java.util.Scanner;

public class FirstNegativeLinear {
    public static int findFirstNegative(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < 0) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] numbers = new int[size];
        
        for (int i = 0; i < size; i++) {
            numbers[i] = scanner.nextInt();
        }
        
        int result = findFirstNegative(numbers);
        System.out.println(result);
        scanner.close();
    }
}
