import java.util.ArrayList;
import java.util.Collections;

public class PrimitiveArrayToCollection {
    public static void main(String[] args) {
        double[] prices = {10.5, 20.0, 35.75, 5.5};
        
        ArrayList<Double> priceList = new ArrayList<>();
        for (double price : prices) {
            priceList.add(price);
        }

        double highestPrice = Collections.max(priceList);
        
        double sum = 0;
        for (double price : priceList) {
            sum += price;
        }
        double averagePrice = sum / priceList.size();

        System.out.println("Price List: " + priceList);
        System.out.println("Highest Price: " + highestPrice);
        System.out.println("Average Price: " + averagePrice);
    }
}
