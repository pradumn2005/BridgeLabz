import java.util.ArrayList;
import java.util.List;

public class Storage<T extends WarehouseItem> {

    private List<T> items;

    public Storage() {
        this.items = new ArrayList<>();
    }

    public void addItem(T item) {
        items.add(item);
        System.out.println("Added: " + item.getName() + " to " + item.getCategory() + " storage.");
    }

    public T retrieveItem(int index) {
        if (index >= 0 && index < items.size()) {
            return items.get(index);
        }
        return null;
    }

    public static void displayAllItems(List<? extends WarehouseItem> list) {
        System.out.println("--- Current Storage Inventory ---");
        for (WarehouseItem item : list) {
            System.out.println(item);
        }
        System.out.println("---------------------------------");
    }

    public static void main(String[] args) {
        Storage<Electronics> electronicsStorage = new Storage<>();
        electronicsStorage.addItem(new Electronics("Smart TV"));
        electronicsStorage.addItem(new Electronics("Wireless Headphones"));

        Storage<Groceries> groceriesStorage = new Storage<>();
        groceriesStorage.addItem(new Groceries("Milk"));
        groceriesStorage.addItem(new Groceries("Bread"));

        List<Electronics> eList = List.of(new Electronics("Tablet"), new Electronics("Camera"));
        List<Groceries> gList = List.of(new Groceries("Eggs"), new Groceries("Yogurt"));

        displayAllItems(eList);
        displayAllItems(gList);
    }
}
