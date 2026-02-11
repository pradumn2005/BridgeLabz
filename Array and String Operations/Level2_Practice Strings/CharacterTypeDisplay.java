import java.util.Scanner;

public class CharacterTypeDisplay {
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

    public static String[][] getCharacterTypes(String text) {
        String[][] results = new String[text.length()][2];
        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);
            results[i][0] = String.valueOf(currentChar);
            results[i][1] = checkCharacterType(currentChar);
        }
        return results;
    }

    public static void displayTable(String[][] data) {
        System.out.println(String.format("%-10s | %-15s", "Character", "Type"));
        System.out.println("------------------------------");
        for (int i = 0; i < data.length; i++) {
            System.out.println(String.format("%-10s | %-15s", data[i][0], data[i][1]));
        }
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

        String[][] charData = getCharacterTypes(text);
        displayTable(charData);
        
        scanner.close();
    }
}
