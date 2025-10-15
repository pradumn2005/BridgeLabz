
import java.util.function.Function;
public class StringLength {
    public static void main(String[] args) {
        Function<String, Integer> lengthCheck = s -> s.length();
        System.out.println("Length: " + lengthCheck.apply("Hello World"));
    }
}
