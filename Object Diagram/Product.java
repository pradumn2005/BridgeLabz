import java.util.*;

class Product {
    String name; double price; double qty;
    Product(String n,double p,double q){ name=n; price=p; qty=q; }
    double total(){ return price*qty; }
}

class Customer {
    String name; ArrayList<Product> items=new ArrayList<>();
    Customer(String n){ name=n; }
    void buy(Product p){ items.add(p); }
}

class BillGenerator {
    double generate(Customer c){
        double sum=0;
        for(Product p:c.items) sum+=p.total();
        return sum;
    }
}

public class Main2 {
    public static void main(String[] args){
        Customer c=new Customer("Alice");
        c.buy(new Product("Apples",3,2));
        c.buy(new Product("Milk",2,1));
        BillGenerator b=new BillGenerator();
        System.out.println(c.name+" Bill: $"+b.generate(c));
    }
}
