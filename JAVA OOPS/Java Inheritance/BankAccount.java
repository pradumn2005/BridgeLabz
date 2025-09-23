class BankAccount {
    int accountNumber;
    double balance;
}

class SavingsAccount extends BankAccount {
    double interestRate;
    void displayAccountType() { System.out.println("Savings Account"); }
}

class CheckingAccount extends BankAccount {
    double withdrawalLimit;
    void displayAccountType() { System.out.println("Checking Account"); }
}

class FixedDepositAccount extends BankAccount {
    int duration;
    void displayAccountType() { System.out.println("Fixed Deposit Account"); }
}

public class Main8 {
    public static void main(String[] args) {
        BankAccount b=new SavingsAccount();
        ((SavingsAccount)b).displayAccountType();
    }
}
