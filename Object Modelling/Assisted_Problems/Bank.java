class Bank {
    String name;
    Bank(String n){ name=n; }
    void openAccount(Customer c){
        System.out.println(c.name+" opened account in "+name);
    }
}

class Customer {
    String name; int balance;
    Customer(String n,int b){ name=n; balance=b; }
    void viewBalance(){ System.out.println(name+" Balance: "+balance); }
}

public class Main2 {
    public static void main(String[] args){
        Bank b=new Bank("SBI");
        Customer c1=new Customer("Amit",5000);
        b.openAccount(c1);
        c1.viewBalance();
    }
}
