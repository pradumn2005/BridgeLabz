class Product {
    private static double discount = 10.0;

    private final int productID;
    private String productName;
    private double price;
    private int quantity;

    Product(int productID, String productName, double price, int quantity) {
        this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    public static void updateDiscount(double d) {
        discount = d;
    }

    void display() {
        if (this instanceof Product) {
            double total = price * quantity * (1 - discount / 100);
            System.out.println("ID: " + productID);
            System.out.println("Name: " + productName);
            System.out.println("Price: " + price);
            System.out.println("Quantity: " + quantity);
            System.out.println("Discount: " + discount + "%");
            System.out.println("Total: " + total);
        }
    }

    public static void main(String[] args) {
        Product p = new Product(1, "Laptop", 50000, 2);
        p.display();
        Product.updateDiscount(20);
        p.display();
    }
}
