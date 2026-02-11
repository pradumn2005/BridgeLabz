import java.util.Scanner;
import java.util.Arrays;

public class QuickSortProductPrices {
    public static void quickSort(double[] prices, int low, int high) {
        if (low < high) {
            int pi = partition(prices, low, high);
            quickSort(prices, low, pi - 1);
            quickSort(prices, pi + 1, high);
        }
    }

    public static int partition(double[] prices, int low, int high) {
        double pivot = prices[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (prices[j] <= pivot) {
                i++;
                double temp = prices[i];
                prices[i] = prices[j];
                prices[j] = temp;
            }
        }
        double temp = prices[i + 1];
        prices[i + 1] = prices[high];
        prices[high] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of products: ");
        int count = scanner.nextInt();
        double[] prices = new double[count];
        for (int i = 0; i < count; i++) {
            System.out.print("Enter price for product " + (i + 1) + ": ");
            prices[i] = scanner.nextDouble();
        }
        quickSort(prices, 0, prices.length - 1);
        System.out.println("Sorted Product Prices: " + Arrays.toString(prices));
        scanner.close();
    }
}
