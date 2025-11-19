import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ECommerceSort {

    public static void printList(String title, List<Product> products) {
        System.out.println("\n--- " + title + " ---");
        products.forEach(System.out::println);
    }

    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Laptop", 1200.00, 5, 15.0));
        products.add(new Product("Mouse", 25.00, 4, 10.0));
        products.add(new Product("Monitor", 350.00, 4, 5.0));
        products.add(new Product("Keyboard", 75.00, 5, 20.0));

        // 1. Sort by Price (Ascending)
        Comparator<Product> sortByPrice = (p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice());
        Collections.sort(products, sortByPrice);
        printList("Sorted by Price", products);

        // 2. Sort by Rating (Descending)
        Comparator<Product> sortByRating = (p1, p2) -> Integer.compare(p2.getRating(), p1.getRating());
        Collections.sort(products, sortByRating);
        printList("Sorted by Rating (High to Low)", products);

        // 3. Sort by Discount (Descending)
        Comparator<Product> sortByDiscount = (p1, p2) -> Double.compare(p2.getDiscount(), p1.getDiscount());
        Collections.sort(products, sortByDiscount);
        printList("Sorted by Discount (Highest First)", products);
    }
}
