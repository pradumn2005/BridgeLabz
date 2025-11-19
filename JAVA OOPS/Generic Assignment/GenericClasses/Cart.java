import java.util.ArrayList;
import java.util.List;

public class Cart<T> {

    private List<T> items;
    private String name;

    public Cart(String name) {
        this.name = name;
        this.items = new ArrayList<>();
    }

    public void addItem(T item) {
        items.add(item);
    }

    public void removeItem(T item) {
        items.remove(item);
    }

    public void displayItems() {
        System.out.println(name + " Cart Items (" + items.get(0).getClass().getSimpleName() + " only):");
        for (T item : items) {
            System.out.println("  - " + item);
        }
    }

    // Dummy product classes for demonstration
    public static class Electronics {
        private String name;
        public Electronics(String name) { this.name = name; }
        @Override public String toString() { return "Electronic: " + name; }
    }

    public static class Clothing {
        private String name;
        public Clothing(String name) { this.name = name; }
        @Override public String toString() { return "Clothing: " + name; }
    }

    public static void main(String[] args) {
        Cart<Electronics> electronicsCart = new Cart<>("Electronics");
        electronicsCart.addItem(new Electronics("Laptop"));
        electronicsCart.addItem(new Electronics("Mouse"));
        // electronicsCart.addItem(new Clothing("Shirt")); // Compile error
        electronicsCart.displayItems();

        Cart<Clothing> clothingCart = new Cart<>("Clothing");
        clothingCart.addItem(new Clothing("T-Shirt"));
        clothingCart.addItem(new Clothing("Jeans"));
        clothingCart.displayItems();
    }
}
