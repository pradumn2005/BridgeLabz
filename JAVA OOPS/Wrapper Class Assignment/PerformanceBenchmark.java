import java.util.ArrayList;

public class PerformanceBenchmark {
    public static void main(String[] args) {
        int size = 1_000_000;

        long startTime = System.nanoTime();
        ArrayList<Integer> wrapperList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            wrapperList.add(i);
        }
        
        long sumWrapper = 0;
        for (int val : wrapperList) {
            sumWrapper += val;
        }
        long endTime = System.nanoTime();
        long wrapperTime = (endTime - startTime) / 1_000_000;
        System.out.println("ArrayList<Integer> time: " + wrapperTime + " ms");
        System.out.println("Sum: " + sumWrapper);

        startTime = System.nanoTime();
        int[] primitiveArray = new int[size];
        for (int i = 0; i < size; i++) {
            primitiveArray[i] = i;
        }
        
        long sumPrimitive = 0;
        for (int val : primitiveArray) {
            sumPrimitive += val;
        }
        endTime = System.nanoTime();
        long primitiveTime = (endTime - startTime) / 1_000_000;
        System.out.println("int[] time: " + primitiveTime + " ms");
        System.out.println("Sum: " + sumPrimitive);
    }
}
