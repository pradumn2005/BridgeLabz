public class Product {

    private String name;
    private double price;
    private int rating;
    private double discount;

    public Product(String name, double price, int rating, double discount) {
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getRating() {
        return rating;
    }

    public double getDiscount() {
        return discount;
    }

    @Override
    public String toString() {
        return name + " [Price: $" + price + ", Rating: " + rating + "/5, Discount: " + discount + "%]";
    }
}
