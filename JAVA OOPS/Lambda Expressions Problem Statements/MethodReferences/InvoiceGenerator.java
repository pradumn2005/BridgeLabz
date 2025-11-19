import java.util.List;
import java.util.stream.Collectors;

public class InvoiceGenerator {

    public static void main(String[] args) {
        List<String> transactionIds = List.of("TX-1001", "TX-1002", "TX-1003");

        System.out.println("--- Generating Invoice Objects ---");
        // Method Reference: Invoice::new (Reference to a constructor)
        // The stream maps each String transactionId to a new Invoice object using the constructor that accepts a String.
        List<Invoice> invoices = transactionIds.stream()
            .map(Invoice::new)
            .collect(Collectors.toList());

        System.out.println("\n--- Generated Invoices ---");
        invoices.forEach(System.out::println);
    }
}
