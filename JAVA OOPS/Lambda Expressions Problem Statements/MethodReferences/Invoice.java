public class Invoice {

    private final String transactionId;

    public Invoice(String transactionId) {
        this.transactionId = transactionId;
        System.out.println("Invoice created for transaction: " + transactionId);
    }

    @Override
    public String toString() {
        return "Invoice[" + transactionId + "]";
    }
}
