import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Scanner;

public class WriteUserInput {
    public static void processInputToFile(String filePath) {
        try (InputStreamReader isr = new InputStreamReader(System.in);
             BufferedReader br = new BufferedReader(isr);
             FileWriter fw = new FileWriter(filePath)) {
            
            String input;
            while (!(input = br.readLine()).equalsIgnoreCase("exit")) {
                fw.write(input + System.lineSeparator());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();
        processInputToFile(path);
        scanner.close();
    }
}
