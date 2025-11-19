import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.text.DecimalFormat;

/**
 * Simulates an Online Shopping Cart using LinkedHashMap<String, Double>
 * for product name -> price, preserving insertion order.
 */
public class OnlineShoppingCart {

    // Use LinkedHashMap to preserve insertion order (for task 2)
    private Map<String, Double> cart = new LinkedHashMap<>();
    private static final DecimalFormat df = new DecimalFormat("0.00");
    private static final double DISCOUNT_THRESHOLD = 5000.0;
    private static final double DISCOUNT_RATE = 0.10;

    // 1. Add products in the order they are added to cart.
    public void addItem(String product, double price) {
        cart.put(product, price);
        System.out.println("Added: " + product + " at ₹" + df.format(price));
    }

    // 5. Remove any item if its quantity becomes zero (simulate user removing items).
    public void removeItem(String product) {
        if (cart.remove(product) != null) {
            System.out.println("Removed: " + product + " from cart.");
        } else {
            System.out.println("Item " + product + " is not in the cart.");
        }
    }

    // 2. Display products in order of addition
    public void displayCart() {
        System.out.println("\n--- Current Shopping Cart (Insertion Order) ---");
        if (cart.isEmpty()) {
            System.out.println("Cart is empty.");
            return;
        }
        cart.forEach((product, price) ->
            System.out.println("- " + product + ": ₹" + df.format(price))
        );
    }

    // 3. Calculate the total bill amount and apply discount (Task 4)
    public double calculateTotalBill() {
        // 3. Calculate the total bill amount
        double subTotal = cart.values().stream()
            .mapToDouble(Double::doubleValue)
            .sum();

        double total = subTotal;
        double discount = 0.0;

        // 4. Apply a 10% discount if the total exceeds ₹5000.
        if (subTotal > DISCOUNT_THRESHOLD) {
            discount = subTotal * DISCOUNT_RATE;
            total = subTotal - discount;
            System.out.println("\n--- Discount Applied ---");
            System.out.println("Subtotal: ₹" + df.format(subTotal));
            System.out.println("Discount (" + (int)(DISCOUNT_RATE * 100) + "%): -₹" + df.format(discount));
        }

        System.out.println("\n--- Total Bill ---");
        System.out.println("Total Amount Due: ₹" + df.format(total));
        return total;
    }

    public static void main(String[] args) {
        OnlineShoppingCart cartSystem = new OnlineShoppingCart();

        // 1. Add products
        cartSystem.addItem("Laptop", 45000.0);
        cartSystem.addItem("Wireless Mouse", 1500.0);
        cartSystem.addItem("Mechanical Keyboard", 8000.0);
        cartSystem.addItem("Monitor", 12000.0);

        // 2. Display products
        cartSystem.displayCart();

        // 3 & 4. Calculate total (should trigger discount)
        cartSystem.calculateTotalBill();

        // 5. Remove an item and recalculate
        cartSystem.removeItem("Wireless Mouse");
        cartSystem.calculateTotalBill(); // Discount still applies
    }
}
