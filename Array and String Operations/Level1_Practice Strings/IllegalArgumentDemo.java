import java.util.Scanner;

public class IllegalArgumentDemo {

    public static void generateException(String text) {
        System.out.println(text.substring(5, 1)); 
    }

    public static void handleException(String text) {
        try {
            System.out.println("Attempting invalid substring indices...");
            System.out.println(text.substring(5, 1));
        } catch (IllegalArgumentException e) {
            System.out.println("Exception Caught: " + e);
        } catch (RuntimeException e) {
            System.out.println("Runtime Exception: " + e);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text (at least 6 chars): ");
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
