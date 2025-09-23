
abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;
    public FoodItem(String n,double p,int q){itemName=n;price=p;quantity=q;}
    public double getPrice(){return price;}
    public int getQuantity(){return quantity;}
    public void getItemDetails(){System.out.println(itemName+" "+price+" "+quantity);}
    public abstract double calculateTotalPrice();
}

interface Discountable {
    double applyDiscount();
    String getDiscountDetails();
}

class VegItem extends FoodItem implements Discountable {
    public VegItem(String n,double p,int q){super(n,p,q);}
    public double calculateTotalPrice(){return getPrice()*getQuantity();}
    public double applyDiscount(){return calculateTotalPrice()*0.1;}
    public String getDiscountDetails(){return "10% Discount";}
}

class NonVegItem extends FoodItem implements Discountable {
    public NonVegItem(String n,double p,int q){super(n,p,q);}
    public double calculateTotalPrice(){return getPrice()*getQuantity()+50;}
    public double applyDiscount(){return calculateTotalPrice()*0.05;}
    public String getDiscountDetails(){return "5% Discount";}
}

public class Main6 {
    public static void main(String[] args) {
        FoodItem f=new NonVegItem("Chicken",200,2);
        f.getItemDetails();
        System.out.println(f.calculateTotalPrice());
    }
}
