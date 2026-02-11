import java.util.Scanner;
import java.util.HashSet;

public class RemoveDuplicates {
    public static String removeDuplicatesWithBuilder(String input) {
        StringBuilder sb = new StringBuilder();
        HashSet<Character> seen = new HashSet<>();
        
        for (char c : input.toCharArray()) {
            if (!seen.contains(c)) {
                sb.append(c);
                seen.add(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String result = removeDuplicatesWithBuilder(input);
        System.out.println(result);
        scanner.close();
    }
}
