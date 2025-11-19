public class Product<T extends ProductCategory> {

    private String name;
    private double price;
    private T category;

    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public T getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return name + " (" + category.getCategoryName() + "): $" + String.format("%.2f", price);
    }

    public static <T extends Product<?>> void applyDiscount(T product, double percentage) {
        double currentPrice = product.getPrice();
        double discountAmount = currentPrice * (percentage / 100.0);
        product.setPrice(currentPrice - discountAmount);
        System.out.println("Applied " + percentage + "% discount to " + product.getName() + ". New price: $" + String.format("%.2f", product.getPrice()));
    }

    public static void main(String[] args) {
        Product<BookCategory> book = new Product<>("The Great Novel", 25.00, new BookCategory());
        Product<ClothingCategory> shirt = new Product<>("Casual Shirt", 50.00, new ClothingCategory());
        Product<GadgetCategory> smartWatch = new Product<>("Smart Watch Pro", 200.00, new GadgetCategory());

        System.out.println("Original Prices:");
        System.out.println(book);
        System.out.println(shirt);
        System.out.println(smartWatch);

        System.out.println("\nApplying Discounts:");
        applyDiscount(book, 10.0);
        applyDiscount(shirt, 20.0);
        applyDiscount(smartWatch, 15.0);

        System.out.println("\nUpdated Prices:");
        System.out.println(book);
        System.out.println(shirt);
        System.out.println(smartWatch);
    }
}
