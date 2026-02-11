public class NullPointerDemo {

    public static void generateException() {
        String text = null;
        System.out.println(text.length());
    }

    public static void handleException() {
        String text = null;
        try {
            System.out.println("Attempting to access length of null string...");
            System.out.println(text.length());
        } catch (NullPointerException e) {
            System.out.println("Exception Caught: " + e);
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Handling Exception ---");
        handleException();
        
        System.out.println("\n--- Generating Exception (Program will crash) ---");
        try {
            generateException();
        } catch (Exception e) {
            System.out.println("Main stopped crash for demonstration: " + e);
        }
    }
}
