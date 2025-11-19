public class ValueComparer {

    public static <T> boolean isEqual(T a, T b) {
        if (a == null && b == null) {
            return true;
        }
        if (a == null || b == null) {
            return false;
        }
        return a.equals(b);
    }

    public static void main(String[] args) {
        Integer num1 = 10;
        Integer num2 = 10;
        System.out.println("Integers 10 and 10 are equal: " + isEqual(num1, num2));

        String str1 = "apple";
        String str2 = "orange";
        System.out.println("Strings 'apple' and 'orange' are equal: " + isEqual(str1, str2));
    }
}
