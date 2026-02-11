import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class CountWordOccurrences {
    public static int countWord(String filePath, String targetWord) {
        int count = 0;
        try (FileReader fr = new FileReader(filePath);
             BufferedReader br = new BufferedReader(fr)) {
            
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    if (word.equals(targetWord)) {
                        count++;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();
        String targetWord = scanner.nextLine();
        
        int result = countWord(path, targetWord);
        System.out.println(result);
        scanner.close();
    }
}
