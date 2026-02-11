import java.util.Scanner;

public class VowelConsonantCounter {
    public static String checkCharacterType(char c) {
        int asciiValue = (int) c;
        if (asciiValue >= 65 && asciiValue <= 90) {
            asciiValue += 32;
        }
        
        char lowerChar = (char) asciiValue;
        
        if (lowerChar >= 97 && lowerChar <= 122) {
            if (lowerChar == 'a' || lowerChar == 'e' || lowerChar == 'i' || lowerChar == 'o' || lowerChar == 'u') {
                return "Vowel";
            } else {
                return "Consonant";
            }
        } else {
            return "Not a Letter";
        }
    }

    public static int[] countVowelsAndConsonants(String text) {
        int vowelCount = 0;
        int consonantCount = 0;
        
        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);
            String type = checkCharacterType(currentChar);
            
            if (type.equals("Vowel")) {
                vowelCount++;
            } else if (type.equals("Consonant")) {
                consonantCount++;
            }
        }
        
        return new int[]{vowelCount, consonantCount};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = "";
        
        try {
            text = scanner.nextLine();
        } catch (Exception e) {
            System.out.println("Error reading input.");
            System.exit(1);
        }

        int[] counts = countVowelsAndConsonants(text);

        System.out.println("Total Vowels: " + counts[0]);
        System.out.println("Total Consonants: " + counts[1]);
        
        scanner.close();
    }
}
