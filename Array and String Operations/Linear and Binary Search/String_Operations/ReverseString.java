import java.util.Scanner;

public class ReverseString {
    public static String reverseWithBuilder(String input) {
        StringBuilder sb = new StringBuilder(input);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String result = reverseWithBuilder(input);
        System.out.println(result);
        scanner.close();
    }
}
