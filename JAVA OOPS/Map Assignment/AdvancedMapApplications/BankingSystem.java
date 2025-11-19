import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.text.DecimalFormat;

/**
 * Simulates a Banking System using a HashMap<String, Double> for account number -> balance.
 */
public class BankingSystem {

    private Map<String, Double> accounts = new HashMap<>();
    private static final DecimalFormat df = new DecimalFormat("0.00");

    // 1. Add new customer accounts
    public void addAccount(String accNumber, double initialBalance) {
        if (accounts.containsKey(accNumber)) {
            System.out.println("Account " + accNumber + " already exists.");
            return;
        }
        accounts.put(accNumber, initialBalance);
        System.out.println("Added account " + accNumber + " with balance " + df.format(initialBalance));
    }

    // 2. Allow deposit operation
    public void deposit(String accNumber, double amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be positive.");
            return;
        }
        accounts.computeIfPresent(accNumber, (key, balance) -> balance + amount);
        System.out.println("Deposited " + df.format(amount) + " into " + accNumber + ". New balance: " + df.format(accounts.get(accNumber)));
    }

    // 2. Allow withdrawal operation (with balance checks)
    public void withdraw(String accNumber, double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
            return;
        }
        if (!accounts.containsKey(accNumber)) {
            System.out.println("Account " + accNumber + " not found.");
            return;
        }

        double currentBalance = accounts.get(accNumber);

        if (amount > currentBalance) {
            System.out.println("Withdrawal failed: Account " + accNumber + " has insufficient funds (Current: " + df.format(currentBalance) + ").");
        } else {
            accounts.put(accNumber, currentBalance - amount);
            System.out.println("Withdrew " + df.format(amount) + " from " + accNumber + ". New balance: " + df.format(accounts.get(accNumber)));
        }
    }

    // 3. Print all customers sorted by descending balance
    public void printSortedByBalance() {
        System.out.println("\n--- All Accounts (Sorted by Balance Descending) ---");
        accounts.entrySet().stream()
            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
            .forEach(entry -> System.out.println("Account " + entry.getKey() + ": Balance " + df.format(entry.getValue())));
    }

    // 4. Identify the top 3 customers with the highest balance.
    public void printTopCustomers(int count) {
        System.out.println("\n--- Top " + count + " Customers by Balance ---");
        List<Map.Entry<String, Double>> topCustomers = accounts.entrySet().stream()
            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
            .limit(count)
            .collect(Collectors.toList());

        if (topCustomers.isEmpty()) {
            System.out.println("No accounts found.");
            return;
        }

        for (int i = 0; i < topCustomers.size(); i++) {
            Map.Entry<String, Double> entry = topCustomers.get(i);
            System.out.println((i + 1) + ". Account " + entry.getKey() + " (Balance: " + df.format(entry.getValue()) + ")");
        }
    }

    public static void main(String[] args) {
        BankingSystem bank = new BankingSystem();

        // 1. Add accounts
        bank.addAccount("A101", 5000.0);
        bank.addAccount("B202", 12500.50);
        bank.addAccount("C303", 999.99);
        bank.addAccount("D404", 50000.0);
        bank.addAccount("E505", 25000.0);

        // 2. Operations
        System.out.println("\n--- Transactions ---");
        bank.deposit("A101", 1000.0);
        bank.withdraw("B202", 2500.0);
        bank.withdraw("C303", 1500.0); // Withdrawal fails (insufficient funds)

        // 3. Print sorted
        bank.printSortedByBalance();

        // 4. Print top customers
        bank.printTopCustomers(3);
    }
}
