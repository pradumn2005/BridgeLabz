import java.util.Scanner;

public class SearchWordLinear {
    public static String searchWordInSentences(String[] sentences, String targetWord) {
        for (String sentence : sentences) {
            if (sentence.contains(targetWord)) {
                return sentence;
            }
        }
        return "Not Found";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        scanner.nextLine();
        
        String[] sentences = new String[size];
        for (int i = 0; i < size; i++) {
            sentences[i] = scanner.nextLine();
        }
        
        String targetWord = scanner.nextLine();
        String result = searchWordInSentences(sentences, targetWord);
        System.out.println(result);
        scanner.close();
    }
}
