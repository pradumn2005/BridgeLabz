class Product implements Cloneable {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public void setName(String name) { this.name = name; }
    public void setPrice(double price) { this.price = price; }

    @Override
    public Product clone() {
        try {
            return (Product) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    public void display() {
        System.out.println("Product Name: " + name + ", Price: ₹" + price);
    }
}

public class PrototypeExample {
    public static void main(String[] args) {
        Product prototype = new Product("Smart Watch", 4999.99);
        System.out.println("Original Object:");
        prototype.display();

        Product clonedProduct = prototype.clone();
        clonedProduct.setName("Smart Watch Pro");
        clonedProduct.setPrice(6999.99);

        System.out.println("\nAfter Cloning:");
        System.out.println("Prototype Object:");
        prototype.display();

        System.out.println("Cloned Object:");
        clonedProduct.display();
    }
}
