abstract class BankAccount {
    private int accountNumber;
    private String holderName;
    private double balance;
    public BankAccount(int a,String h,double b){accountNumber=a;holderName=h;balance=b;}
    public void deposit(double amt){balance+=amt;}
    public void withdraw(double amt){balance-=amt;}
    public double getBalance(){return balance;}
    public abstract double calculateInterest();
}

interface Loanable {
    void applyForLoan(double amt);
    boolean calculateLoanEligibility();
}

class SavingsAccount extends BankAccount implements Loanable {
    public SavingsAccount(int a,String h,double b){super(a,h,b);}
    public double calculateInterest(){return getBalance()*0.04;}
    public void applyForLoan(double amt){System.out.println("Savings Loan "+amt);}
    public boolean calculateLoanEligibility(){return getBalance()>1000;}
}

class CurrentAccount extends BankAccount implements Loanable {
    public CurrentAccount(int a,String h,double b){super(a,h,b);}
    public double calculateInterest(){return getBalance()*0.02;}
    public void applyForLoan(double amt){System.out.println("Current Loan "+amt);}
    public boolean calculateLoanEligibility(){return getBalance()>5000;}
}

public class Main4 {
    public static void main(String[] args) {
        BankAccount b=new SavingsAccount(1,"Raj",20000);
        System.out.println(b.calculateInterest());
    }
}
