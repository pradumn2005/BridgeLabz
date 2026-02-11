import java.util.Scanner;

public class NumberFormatDemo {

    public static void generateException(String text) {
        int num = Integer.parseInt(text);
        System.out.println("Number is: " + num);
    }

    public static void handleException(String text) {
        try {
            System.out.println("Parsing number...");
            int num = Integer.parseInt(text);
            System.out.println("Number is: " + num);
        } catch (NumberFormatException e) {
            System.out.println("Exception Caught: Invalid number format.");
        } catch (RuntimeException e) {
            System.out.println("Runtime Exception: " + e);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a non-numeric string: ");
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
