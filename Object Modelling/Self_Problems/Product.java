import java.util.*;

class Product {
    String name; Product(String n){ name=n; }
    public String toString(){ return name; }
}

class Order {
    int id; ArrayList<Product> products=new ArrayList<>();
    Order(int i){ id=i; }
    void addProduct(Product p){ products.add(p); }
    public String toString(){ return "Order"+id+" "+products; }
}

class Customer {
    String name;
    Customer(String n){ name=n; }
    Order placeOrder(int id){ return new Order(id); }
}

public class Main4 {
    public static void main(String[] args){
        Customer c=new Customer("Neha");
        Order o=c.placeOrder(101);
        o.addProduct(new Product("Laptop"));
        o.addProduct(new Product("Phone"));
        System.out.println(c.name+" placed "+o);
    }
}
