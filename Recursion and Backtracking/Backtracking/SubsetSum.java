import java.util.ArrayList;
import java.util.List;

public class SubsetSum {
    public static boolean findSubset(int[] numbers, int target, int index, List<Integer> currentSolution) {
        if (target == 0) {
            System.out.println("Solution found: " + currentSolution);
            return true;
        }
        if (target < 0 || index >= numbers.length) {
            return false;
        }

        currentSolution.add(numbers[index]);
        if (findSubset(numbers, target - numbers[index], index + 1, currentSolution)) {
            return true;
        }
        currentSolution.remove(currentSolution.size() - 1);

        if (findSubset(numbers, target, index + 1, currentSolution)) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        int[] numbers = {3, 34, 4, 12, 5, 2};
        int target = 9;
        findSubset(numbers, target, 0, new ArrayList<>());
    }
}
