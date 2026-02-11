import java.util.Scanner;

public class CustomStringLength {
    public static int findLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            return count;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string (no spaces): ");
        String text = "";
        
        try {
            text = scanner.next();
        } catch (Exception e) {
            System.out.println("Error reading input.");
            System.exit(1);
        }

        int customLength = findLength(text);
        int builtInLength = text.length();

        System.out.println("Length using custom method: " + customLength);
        System.out.println("Length using built-in method: " + builtInLength);

        if (customLength == builtInLength) {
            System.out.println("Results match.");
        } else {
            System.out.println("Results do not match.");
        }
        
        scanner.close();
    }
}
