import java.util.ArrayList;

public class AutoboxingSum {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();

        numbers.add(10);
        numbers.add(5);
        numbers.add(15);
        numbers.add(20);
        numbers.add(5);

        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }

        System.out.println("Sum of numbers = " + sum);
    }
}
