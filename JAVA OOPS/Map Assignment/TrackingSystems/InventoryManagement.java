import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Simulates an Inventory Management system using a Map<String, Integer>
 * for product name -> quantity.
 */
public class InventoryManagement {

    private Map<String, Integer> inventory = new HashMap<>();

    // 1. Add new products
    public void addProduct(String product, int quantity) {
        inventory.put(product, inventory.getOrDefault(product, 0) + quantity);
    }

    // 2. Reduce quantity (customer buys)
    public void sellProduct(String product, int quantitySold) {
        if (inventory.containsKey(product)) {
            int currentQuantity = inventory.get(product);
            int newQuantity = currentQuantity - quantitySold;

            if (newQuantity > 0) {
                inventory.put(product, newQuantity);
                System.out.println("Sold " + quantitySold + " of " + product + ". Remaining: " + newQuantity);
            } else {
                // If quantity goes to zero or below, mark as "out of stock" by removing
                inventory.remove(product);
                System.out.println(product + " is now OUT OF STOCK (removed from map).");
            }
        } else {
            System.out.println("Product " + product + " not stocked.");
        }
    }

    // 3. Increase quantity (new shipment)
    public void restockProduct(String product, int quantityReceived) {
        addProduct(product, quantityReceived);
        System.out.println("Restocked " + product + " by " + quantityReceived + ". New total: " + inventory.get(product));
    }

    // 4. Query remaining quantity
    public void queryProduct(String product) {
        Integer quantity = inventory.get(product);
        if (quantity != null) {
            System.out.println(product + " in stock: " + quantity);
        } else {
            System.out.println(product + ": Not stocked (Out of Stock or never added).");
        }
    }

    // Print all products that are out of stock (i.e., not in the map)
    public void printOutOfStock() {
        // In this implementation, "out of stock" means the product is not in the map
        // To truly track, we'd need a separate "all products" list or set initial quantity to 0
        // Based on the requirement 'If quantity goes to zero or below, mark as “out of stock” by removing',
        // we'll just print the current inventory.
        System.out.println("\n--- Current Inventory ---");
        if (inventory.isEmpty()) {
            System.out.println("All items are out of stock!");
        } else {
            inventory.forEach((p, q) -> System.out.println(p + ": " + q));
        }
    }

    public static void main(String[] args) {
        InventoryManagement manager = new InventoryManagement();

        // 1. Add new products
        manager.addProduct("Laptop", 10);
        manager.addProduct("Mouse", 50);
        manager.addProduct("Keyboard", 5);

        // 4. Initial query
        manager.queryProduct("Laptop");

        // 2. Customer buys
        manager.sellProduct("Mouse", 49);
        manager.sellProduct("Keyboard", 5); // Goes out of stock

        // 3. New shipment
        manager.restockProduct("Laptop", 5);

        // 2. Sell one more, to test a product that was removed
        manager.sellProduct("Keyboard", 1); // Should say "not stocked"

        // Final report
        manager.printOutOfStock();
    }
}
