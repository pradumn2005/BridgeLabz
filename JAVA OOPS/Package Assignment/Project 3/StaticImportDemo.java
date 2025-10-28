import static java.lang.Math.*;

public class StaticImportDemo {
    public static void main(String[] args) {
        double num1 = 16.0;
        double num2 = -8.5;

        // Step 2: Using static methods without 'Math.' prefix
        System.out.println("Square root of " + num1 + " = " + sqrt(num1));
        System.out.println(num1 + " raised to power 2 = " + pow(num1, 2));
        System.out.println("Maximum of " + num1 + " and " + num2 + " = " + max(num1, num2));
        System.out.println("Minimum of " + num1 + " and " + num2 + " = " + min(num1, num2));
        System.out.println("Absolute value of " + num2 + " = " + abs(num2));
    }
}