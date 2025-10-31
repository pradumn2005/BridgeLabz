public class BankTransactionLimits {

    public static double getRemainingLimit(Double dailyLimit, double withdrawal) {
        if (dailyLimit == null) {
            return 0.0;
        }
        return dailyLimit - withdrawal;
    }

    public static void main(String[] args) {
        Double limit1 = 1000.0;
        Double limit2 = null;
        double withdrawal = 250.0;

        System.out.println("Remaining limit for account 1: " + getRemainingLimit(limit1, withdrawal));
        System.out.println("Remaining limit for account 2: " + getRemainingLimit(limit2, withdrawal));
    }
}
