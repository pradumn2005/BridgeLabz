import java.util.*;

/**
 * E-Commerce Order Processing System using List, Set, Queue, and Stack.
 */
class Order {
    private String orderId;
    private String product;
    private boolean isDuplicate;

    public Order(String orderId, String product) {
        this.orderId = orderId;
        this.product = product;
        this.isDuplicate = false;
    }
    public String getOrderId() { return orderId; }
    public void markAsDuplicate() { this.isDuplicate = true; }
    public boolean isDuplicate() { return isDuplicate; }

    @Override public String toString() { return "Order:" + orderId + " (" + product + ")"; }
    // equals/hashCode based on orderId for Set usage
    @Override public boolean equals(Object o) { if (this == o) return true; if (o == null || getClass() != o.getClass()) return false; Order order = (Order) o; return orderId.equals(order.orderId); }
    @Override public int hashCode() { return orderId.hashCode(); }
}

public class ECommerceOrderProcessing {
    private List<Order> allOrders = new ArrayList<>();
    private Set<String> processedOrderIds = new HashSet<>();
    private Queue<Order> validOrderQueue = new LinkedList<>();
    private Stack<Order> failedOrderStack = new Stack<>();

    // 1. Add orders to the system
    public void addOrder(Order order) {
        allOrders.add(order);
        System.out.println("-> Placed " + order);
    }

    // 2. Identify and remove duplicate orders (or mark them)
    public void filterDuplicates() {
        System.out.println("\n--- Filtering Duplicates ---");
        for (Order order : allOrders) {
            if (processedOrderIds.add(order.getOrderId())) {
                validOrderQueue.add(order);
            } else {
                order.markAsDuplicate();
                System.out.println("! Duplicate found and removed: " + order);
            }
        }
        System.out.println("Valid orders queued: " + validOrderQueue.size());
    }

    // 3. Process all valid orders in order of placement (FIFO)
    public void processOrders() {
        System.out.println("\n--- Processing Valid Orders (FIFO) ---");
        while (!validOrderQueue.isEmpty()) {
            Order order = validOrderQueue.remove();
            System.out.print("Processing " + order + "...");
            
            // Simulate processing success/failure
            if (Math.random() > 0.8) { // 20% failure chance
                System.out.println(" FAILED.");
                failedOrderStack.push(order);
            } else {
                System.out.println(" Success.");
            }
        }
    }

    // 4. Re-process failed orders from the stack (LIFO)
    public void reprocessFailedOrders() {
        System.out.println("\n--- Reprocessing Failed Orders (LIFO) ---");
        while (!failedOrderStack.isEmpty()) {
            Order failedOrder = failedOrderStack.pop();
            System.out.println("Retrying " + failedOrder + "...");
            // In a real system, you'd re-queue or handle it here
            System.out.println("   Reprocessed " + failedOrder.getOrderId() + " successfully.");
        }
    }

    public static void main(String[] args) {
        ECommerceOrderProcessing system = new ECommerceOrderProcessing();

        // Add orders
        system.addOrder(new Order("ORD101", "Laptop"));
        system.addOrder(new Order("ORD102", "Mouse"));
        system.addOrder(new Order("ORD101", "Monitor")); // Duplicate ID, different product
        system.addOrder(new Order("ORD103", "Keyboard"));

        system.filterDuplicates();
        system.processOrders();
        system.reprocessFailedOrders();
    }
}
