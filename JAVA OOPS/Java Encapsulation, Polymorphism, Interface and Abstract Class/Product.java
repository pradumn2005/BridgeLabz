abstract class Product {
    private int productId;
    private String name;
    private double price;
    public Product(int id,String n,double p){productId=id;name=n;price=p;}
    public double getPrice(){return price;}
    public abstract double calculateDiscount();
    public void displayFinalPrice(double tax){
        System.out.println(name+" "+(price+tax-calculateDiscount()));
    }
}

interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

class Electronics extends Product implements Taxable {
    public Electronics(int id,String n,double p){super(id,n,p);}
    public double calculateDiscount(){return getPrice()*0.1;}
    public double calculateTax(){return getPrice()*0.18;}
    public String getTaxDetails(){return "18% GST";}
}

class Clothing extends Product implements Taxable {
    public Clothing(int id,String n,double p){super(id,n,p);}
    public double calculateDiscount(){return getPrice()*0.2;}
    public double calculateTax(){return getPrice()*0.05;}
    public String getTaxDetails(){return "5% VAT";}
}

class Groceries extends Product {
    public Groceries(int id,String n,double p){super(id,n,p);}
    public double calculateDiscount(){return getPrice()*0.05;}
}

public class Main2 {
    public static void main(String[] args) {
        Product p1=new Electronics(1,"Laptop",50000);
        Product p2=new Clothing(2,"Shirt",2000);
        Product p3=new Groceries(3,"Apple",100);
        ((Electronics)p1).displayFinalPrice(((Electronics)p1).calculateTax());
        ((Clothing)p2).displayFinalPrice(((Clothing)p2).calculateTax());
        p3.displayFinalPrice(0);
    }
}
