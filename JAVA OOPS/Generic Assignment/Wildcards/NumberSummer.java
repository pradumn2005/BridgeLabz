import java.util.Arrays;
import java.util.List;

public class NumberSummer {

    public static double sumNumbers(List<? extends Number> list) {
        double sum = 0.0;
        for (Number number : list) {
            sum += number.doubleValue();
        }
        return sum;
    }

    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println("Sum of integers: " + sumNumbers(integerList));

        List<Double> doubleList = Arrays.asList(1.5, 2.5, 3.0);
        System.out.println("Sum of doubles: " + sumNumbers(doubleList));
    }
}
