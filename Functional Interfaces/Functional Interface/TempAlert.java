
import java.util.function.Predicate;
public class TempAlert {
    public static void main(String[] args) {
        Predicate<Double> isHot = t -> t > 40;
        System.out.println(isHot.test(42.0) ? "Alert: High Temp!" : "Normal Temp");
    }
}
