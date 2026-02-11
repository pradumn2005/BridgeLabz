import java.util.Scanner;

public class ArrayIndexOutOfBoundsDemo {

    public static void generateException(String[] names) {
        System.out.println(names[names.length]);
    }

    public static void handleException(String[] names) {
        try {
            System.out.println("Accessing invalid array index...");
            System.out.println(names[names.length]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Exception Caught: " + e);
        } catch (RuntimeException e) {
            System.out.println("Runtime Exception: " + e);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of names: ");
        int size = scanner.nextInt();
        String[] names = new String[size];
        
        for(int i=0; i<size; i++) {
            System.out.print("Enter name " + (i+1) + ": ");
            names[i] = scanner.next();
        }

        System.out.println("--- Handling Exception ---");
        handleException(names);
        
        System.out.println("\n--- Generating Exception ---");
        try {
            generateException(names);
        } catch (Exception e) {
            System.out.println("Stopped crash: " + e);
        }
    }
}
