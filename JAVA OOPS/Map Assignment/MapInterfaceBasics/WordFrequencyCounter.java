import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Reads a text and counts the frequency of each word using a HashMap,
 * ignoring case and punctuation.
 * Input: "Hello world, hello Java!" -> Output: {hello=2, world=1, java=1}
 */
public class WordFrequencyCounter {

    public static Map<String, Integer> countWords(String text) {
        Map<String, Integer> wordCounts = new HashMap<>();

        // Use a simple regex to find sequences of letters, normalizing to lowercase
        Pattern pattern = Pattern.compile("\\b[a-zA-Z]+\\b");
        Matcher matcher = pattern.matcher(text.toLowerCase());

        while (matcher.find()) {
            String word = matcher.group();
            // Use getOrDefault for clean incrementing
            wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
        }

        return wordCounts;
    }

    public static void main(String[] args) {
        String input = "Hello world, hello Java! Java is fun.";
        Map<String, Integer> result = countWords(input);
        System.out.println("Input: \"" + input + "\"");
        System.out.println("Word Frequencies: " + result);
    }
}
