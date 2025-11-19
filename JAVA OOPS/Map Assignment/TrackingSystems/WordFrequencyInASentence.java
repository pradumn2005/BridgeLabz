import java.util.HashMap;
import java.util.Map;

/**
 * Counts how many times each word appears in a given sentence,
 * using Map<String, Integer> for word -> count.
 */
public class WordFrequencyInASentence {

    public static void main(String[] args) {
        // 1. Take a sentence
        String sentence = "Java is fun and Java is powerful. Java is the best!";
        System.out.println("Original Sentence: \"" + sentence + "\"");

        // 2. Split into words, normalize (lowercase, remove punctuation).
        // Replace all non-word characters with a space, then split by space.
        String normalized = sentence.toLowerCase().replaceAll("[^a-zA-Z\\s]", " ");
        String[] words = normalized.split("\\s+");

        Map<String, Integer> wordCounts = new HashMap<>();

        System.out.println("\n--- Word Counts ---");
        // 3. For each word, if key present increment count, else add with count 1.
        for (String word : words) {
            if (word.isEmpty()) continue; // Skip empty strings from split

            // Use Map.merge for the conditional increment
            wordCounts.merge(word, 1, Integer::sum);
        }

        // 4. Print each word with its count.
        wordCounts.forEach((word, count) ->
            System.out.println("'" + word + "': " + count)
        );
    }
}
