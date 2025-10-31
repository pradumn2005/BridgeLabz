import java.util.ArrayList;
import java.util.Collections;

public class EmployeeDataProcessing {
    public static void main(String[] args) {
        int[] ages = {34, 22, 45, 28, 51, 22};

        ArrayList<Integer> ageList = new ArrayList<>();
        for (int age : ages) {
            ageList.add(age);
        }

        int youngest = Collections.min(ageList);
        int oldest = Collections.max(ageList);

        System.out.println("Ages: " + ageList);
        System.out.println("Youngest employee age: " + youngest);
        System.out.println("Oldest employee age: " + oldest);
    }
}
