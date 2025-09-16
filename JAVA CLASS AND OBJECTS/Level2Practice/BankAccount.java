import java.util.*;
class BankAccount {
    String accountHolder;
    long accountNumber;
    double balance;
    BankAccount(String h, long n, double b) {
        accountHolder = h;
        accountNumber = n;
        balance = b;
    }
    void deposit(double amt) {
        balance += amt;
        System.out.println("Deposited: " + amt);
    }
    void withdraw(double amt) {
        if (amt <= balance) {
            balance -= amt;
            System.out.println("Withdrawn: " + amt);
        } else System.out.println("Insufficient Balance");
    }
    void display() {
        System.out.println("Holder: " + accountHolder);
        System.out.println("Acc No: " + accountNumber);
        System.out.println("Balance: " + balance);
    }
    public static void main(String[] args) {
        BankAccount b = new BankAccount("Amit", 123456789, 1000);
        b.deposit(500);
        b.withdraw(800);
        b.display();
    }
}
