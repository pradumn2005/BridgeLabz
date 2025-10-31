import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ProductRatingsAnalyzer {
    public static void main(String[] args) {
        int[] oldRatings = {4, 5, 3};
        ArrayList<Integer> newRatings = new ArrayList<>(Arrays.asList(5, 4, null, 5, 2));

        List<Integer> allRatings = new ArrayList<>();
        
        for (int rating : oldRatings) {
            allRatings.add(rating);
        }
        
        allRatings.addAll(newRatings);
        
        double sum = 0;
        int validCount = 0;
        
        for (Integer rating : allRatings) {
            if (Objects.nonNull(rating)) {
                sum += rating;
                validCount++;
            }
        }
        
        double average = sum / validCount;

        System.out.println("All ratings (with nulls): " + allRatings);
        System.out.println("Average of valid ratings: " + average);
    }
}
