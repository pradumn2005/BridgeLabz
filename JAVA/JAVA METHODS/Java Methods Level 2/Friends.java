import java.util.*;

class Friends {
    public static int findYoungest(int[] ages) {
        int minIdx = 0;
        for (int i = 1; i < ages.length; i++) if (ages[i] < ages[minIdx]) minIdx = i;
        return minIdx;
    }

    public static int findTallest(int[] heights) {
        int maxIdx = 0;
        for (int i = 1; i < heights.length; i++) if (heights[i] > heights[maxIdx]) maxIdx = i;
        return maxIdx;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int[] ages = new int[3];
        int[] heights = new int[3];
        String[] names = {"Amar", "Akbar", "Anthony"};
        for (int i = 0; i < 3; i++) ages[i] = sc.nextInt();
        for (int i = 0; i < 3; i++) heights[i] = sc.nextInt();
        System.out.println("Youngest: " + names[findYoungest(ages)]);
        System.out.println("Tallest: " + names[findTallest(heights)]);
    }
}
