import java.util.Scanner;

public class ConcatenateStrings {
    public static String concatenateWithBuffer(String[] words) {
        StringBuffer sb = new StringBuffer();
        for (String word : words) {
            sb.append(word);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        scanner.nextLine();
        
        String[] words = new String[count];
        for (int i = 0; i < count; i++) {
            words[i] = scanner.nextLine();
        }
        
        String result = concatenateWithBuffer(words);
        System.out.println(result);
        scanner.close();
    }
}
