
class BankAccount {
    public long accountNumber;
    protected String accountHolder;
    private double balance;
    BankAccount(long n, String h, double b) {
        accountNumber = n;
        accountHolder = h;
        balance = b;
    }
    public double getBalance() {
        return balance;
    }
    public void deposit(double amt) {
        balance += amt;
    }
    public void withdraw(double amt) {
        if (amt <= balance) balance -= amt;
    }
}
class SavingsAccount extends BankAccount {
    double interestRate;
    SavingsAccount(long n, String h, double b, double r) {
        super(n, h, b);
        interestRate = r;
    }
    void display() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Holder: " + accountHolder);
        System.out.println("Balance: " + getBalance());
        System.out.println("Interest Rate: " + interestRate + "%");
    }
    public static void main(String[] args) {
        SavingsAccount s = new SavingsAccount(111222333, "Amit", 5000, 4.5);
        s.display();
        s.deposit(2000);
        s.withdraw(1000);
        System.out.println("Updated Balance: " + s.getBalance());
    }
}
