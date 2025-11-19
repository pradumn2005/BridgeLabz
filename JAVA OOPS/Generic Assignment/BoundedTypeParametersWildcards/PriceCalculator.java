import java.util.List;
import java.util.Arrays;

public class PriceCalculator {

    public static double calculateTotal(List<? extends Product> items) {
        double total = 0.0;
        for (Product item : items) {
            total += item.getPrice();
        }
        return total;
    }

    public static void main(String[] args) {
        List<Mobile> mobiles = Arrays.asList(new Mobile(500.00), new Mobile(750.00));
        System.out.println("Total price of mobiles: $" + calculateTotal(mobiles));

        List<Laptop> laptops = Arrays.asList(new Laptop(1200.00), new Laptop(1500.00));
        System.out.println("Total price of laptops: $" + calculateTotal(laptops));

        List<Product> mixedItems = Arrays.asList(new Mobile(600.00), new Laptop(1100.00));
        System.out.println("Total price of mixed items: $" + calculateTotal(mixedItems));
    }
}
