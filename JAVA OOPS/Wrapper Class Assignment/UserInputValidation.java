public class UserInputValidation {

    public static boolean isValidAge(String input) {
        try {
            int age = Integer.parseInt(input);
            return age >= 18;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println("Is \"25\" valid and >= 18? " + isValidAge("25"));
        System.out.println("Is \"16\" valid and >= 18? " + isValidAge("16"));
        System.out.println("Is \"abc\" valid and >= 18? " + isValidAge("abc"));
        System.out.println("Is \"\" valid and >= 18? " + isValidAge(""));
    }
}
