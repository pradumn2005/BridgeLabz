import java.util.ArrayList;
import java.util.List;

public class FruitBox<T extends Fruit> {

    private List<T> fruits;

    public FruitBox() {
        this.fruits = new ArrayList<>();
    }

    public void add(T fruit) {
        fruits.add(fruit);
    }

    public void displayFruits() {
        System.out.print("Box contains: ");
        for (T fruit : fruits) {
            System.out.print(fruit.getName() + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        FruitBox<Apple> appleBox = new FruitBox<>();
        appleBox.add(new Apple());
        appleBox.add(new Apple());
        appleBox.displayFruits();

        FruitBox<Fruit> mixedBox = new FruitBox<>();
        mixedBox.add(new Mango());
        mixedBox.add(new Apple());
        mixedBox.displayFruits();

        // Uncommenting the next line will cause a compile-time error
        // FruitBox<String> nonFruitBox = new FruitBox<>();
    }
}
