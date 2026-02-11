import java.util.Arrays;
import java.util.Scanner;

public class CharArrayConverter {

    public static char[] getCharacters(String text) {
        char[] chars = new char[text.length()];
        for (int i = 0; i < text.length(); i++) {
            chars[i] = text.charAt(i);
        }
        return chars;
    }

    public static boolean compareArrays(char[] arr1, char[] arr2) {
        if (arr1.length != arr2.length) return false;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter text: ");
        String text = scanner.next();
        
        char[] customArray = getCharacters(text);
        char[] builtInArray = text.toCharArray();
        
        System.out.println("Custom Array: " + Arrays.toString(customArray));
        System.out.println("Built-in Array: " + Arrays.toString(builtInArray));
        
        if (compareArrays(customArray, builtInArray)) {
            System.out.println("Arrays are identical.");
        } else {
            System.out.println("Arrays differ.");
        }
    }
}
