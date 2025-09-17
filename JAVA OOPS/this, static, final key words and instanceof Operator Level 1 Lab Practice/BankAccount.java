class BankAccount {
    private static String bankName = "State Bank of India";
    private static int totalAccounts = 0;

    private final long accountNumber;
    private String accountHolderName;
    private double balance;

    BankAccount(long accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
        totalAccounts++;
    }

    public static void getTotalAccounts() {
        System.out.println("Total Accounts: " + totalAccounts);
    }

    void display() {
        if (this instanceof BankAccount) {
            System.out.println("Bank: " + bankName);
            System.out.println("Account No: " + accountNumber);
            System.out.println("Holder: " + accountHolderName);
            System.out.println("Balance: " + balance);
        }
    }

    public static void main(String[] args) {
        BankAccount a1 = new BankAccount(1111, "Amit", 5000);
        BankAccount a2 = new BankAccount(2222, "Ravi", 8000);
        a1.display();
        a2.display();
        BankAccount.getTotalAccounts();
    }
}
