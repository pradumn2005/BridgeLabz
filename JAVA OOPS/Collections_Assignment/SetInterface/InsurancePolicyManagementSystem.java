import java.util.*;
import java.time.LocalDate;

/**
 * Represents a simplified Insurance Policy.
 * Note: equals() and hashCode() are crucial for proper Set functionality.
 */
class Policy implements Comparable<Policy> {
    private String policyNumber;
    private String holderName;
    private LocalDate expiryDate;
    private String coverageType;
    private double premiumAmount;

    public Policy(String policyNumber, String holderName, LocalDate expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.holderName = holderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    public String getPolicyNumber() { return policyNumber; }
    public LocalDate getExpiryDate() { return expiryDate; }
    public String getCoverageType() { return coverageType; }

    @Override
    public String toString() {
        return String.format("%s (%s, Exp: %s, Pr: %.2f)", policyNumber, coverageType, expiryDate, premiumAmount);
    }

    // Required for HashSet and LinkedHashSet to identify unique policies by policyNumber
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Policy policy = (Policy) o;
        return policyNumber.equals(policy.policyNumber);
    }

    @Override
    public int hashCode() {
        return policyNumber.hashCode();
    }

    // Required for TreeSet to sort policies by expiry date
    @Override
    public int compareTo(Policy other) {
        int dateComparison = this.expiryDate.compareTo(other.expiryDate);
        if (dateComparison != 0) {
            return dateComparison;
        }
        // Use policy number as a tie-breaker (required for TreeSet uniqueness)
        return this.policyNumber.compareTo(other.policyNumber);
    }
}

/**
 * Demonstrates the use and comparison of HashSet, LinkedHashSet, and TreeSet
 * for policy management.
 */
public class InsurancePolicyManagementSystem {

    private Set<Policy> hashSetPolicies = new HashSet<>();
    private Set<Policy> linkedHashSetPolicies = new LinkedHashSet<>();
    private Set<Policy> treeSetPolicies = new TreeSet<>();

    private List<Policy> allPolicies = new ArrayList<>(); // To check for duplicates

    // 1. Store Unique Policies (Add)
    public void storePolicy(Policy policy) {
        hashSetPolicies.add(policy);
        linkedHashSetPolicies.add(policy);
        treeSetPolicies.add(policy);
        allPolicies.add(policy); // Track all attempts to find duplicates
    }

    // 2. Retrieve All Unique Policies (HashSet for quick lookups)
    public void displayAllUniquePolicies() {
        System.out.println("\n--- All Unique Policies (HashSet/Quick Lookup Order) ---");
        hashSetPolicies.forEach(System.out::println);
    }

    // 2. Retrieve Policies Expiring Soon (Using TreeSet's sorted nature)
    public void displayPoliciesExpiringSoon(int days) {
        LocalDate expiryThreshold = LocalDate.now().plusDays(days);
        System.out.println("\n--- Policies Expiring within " + days + " Days (Sorted by Date) ---");

        // TreeSet is already sorted, we just iterate and check the condition
        for (Policy policy : treeSetPolicies) {
            if (policy.getExpiryDate().isBefore(expiryThreshold) || policy.getExpiryDate().isEqual(expiryThreshold)) {
                System.out.println(policy);
            }
        }
    }

    // 2. Retrieve Policies with a Specific Coverage Type
    public void displayPoliciesByCoverage(String type) {
        System.out.println("\n--- Policies with Coverage Type: " + type + " ---");
        hashSetPolicies.stream()
            .filter(p -> p.getCoverageType().equalsIgnoreCase(type))
            .forEach(System.out::println);
    }

    // 2. Identify Duplicate Policies (Requires using the original insertion list)
    public void displayDuplicatePolicies() {
        Set<String> uniqueNumbers = new HashSet<>();
        Set<String> duplicates = new HashSet<>();

        // Iterate through the original list of policies added
        for (Policy p : allPolicies) {
            if (!uniqueNumbers.add(p.getPolicyNumber())) {
                duplicates.add(p.getPolicyNumber());
            }
        }

        System.out.println("\n--- Duplicate Policy Numbers Found ---");
        if (duplicates.isEmpty()) {
            System.out.println("No duplicates found.");
        } else {
            duplicates.forEach(num -> System.out.println("Duplicate Policy Number: " + num));
        }
    }

    // 3. Simple comparison simulation (Demonstrate the properties)
    public void performanceComparisonDemonstration() {
        System.out.println("\n--- Performance Comparison Demonstration ---");

        System.out.println("1. HashSet Size (Insertion order ignored, fast lookup): " + hashSetPolicies.size());

        System.out.println("2. LinkedHashSet Order (Insertion order maintained):");
        linkedHashSetPolicies.forEach(p -> System.out.print(p.getPolicyNumber() + " -> "));
        System.out.println("END");

        System.out.println("3. TreeSet Order (Sorted by Expiry Date):");
        treeSetPolicies.forEach(p -> System.out.println(p.getPolicyNumber() + " expiring " + p.getExpiryDate()));
    }

    public static void main(String[] args) {
        InsurancePolicyManagementSystem system = new InsurancePolicyManagementSystem();

        LocalDate today = LocalDate.now();

        // Add policies (with one duplicate policy number, P100)
        system.storePolicy(new Policy("P100", "Alice", today.plusDays(5), "Health", 500.0));
        system.storePolicy(new Policy("P200", "Bob", today.plusDays(60), "Auto", 1200.0));
        system.storePolicy(new Policy("P300", "Charlie", today.plusDays(10), "Home", 800.0));
        system.storePolicy(new Policy("P400", "David", today.plusDays(1), "Auto", 700.0));
        // This policy has a duplicate number (P100), but different data. Only one P100 will be in the Sets.
        system.storePolicy(new Policy("P100", "Eve", today.plusDays(90), "Health", 600.0));

        system.displayAllUniquePolicies();
        system.displayDuplicatePolicies();
        system.displayPoliciesExpiringSoon(30);
        system.displayPoliciesByCoverage("Auto");
        system.performanceComparisonDemonstration();
    }
}
