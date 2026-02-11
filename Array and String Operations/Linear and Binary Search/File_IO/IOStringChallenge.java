import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class IOStringChallenge {
    public static void compareStringClasses(int iterations, String text) {
        StringBuilder builder = new StringBuilder();
        long startBuilder = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            builder.append(text);
        }
        long endBuilder = System.nanoTime();

        StringBuffer buffer = new StringBuffer();
        long startBuffer = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            buffer.append(text);
        }
        long endBuffer = System.nanoTime();

        System.out.println(endBuilder - startBuilder);
        System.out.println(endBuffer - startBuffer);
    }

    public static void countWordsInFile(String filePath) {
        long startRead = System.nanoTime();
        int wordCount = 0;
        try (FileReader fr = new FileReader(filePath);
             BufferedReader br = new BufferedReader(fr)) {
            
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                wordCount += words.length;
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        long endRead = System.nanoTime();

        System.out.println(wordCount);
        System.out.println(endRead - startRead);
    }

    public static void main(String[] args) {
        int iterations = 1000000;
        String text = "hello";
        compareStringClasses(iterations, text);
        
        String largeFilePath = "largefile.txt";
        countWordsInFile(largeFilePath);
    }
}
