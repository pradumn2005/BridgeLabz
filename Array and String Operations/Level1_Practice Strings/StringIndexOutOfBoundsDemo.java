import java.util.Scanner;

public class StringIndexOutOfBoundsDemo {

    public static void generateException(String text) {
        System.out.println(text.charAt(text.length() + 1));
    }

    public static void handleException(String text) {
        try {
            System.out.println("Attempting to access invalid index...");
            System.out.println(text.charAt(text.length() + 1));
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Exception Caught: " + e);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = scanner.next();

        System.out.println("--- Handling Exception ---");
        handleException(text);
        
        System.out.println("\n--- Generating Exception ---");
        try {
            generateException(text);
        } catch (Exception e) {
            System.out.println("Stopped crash: " + e);
        }
    }
}
