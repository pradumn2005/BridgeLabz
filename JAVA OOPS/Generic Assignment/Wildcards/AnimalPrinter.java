import java.util.List;
import java.util.Arrays;

public class AnimalPrinter {

    public static void printAnimals(List<? extends Animal> animals) {
        for (Animal animal : animals) {
            animal.speak();
        }
    }

    public static void main(String[] args) {
        List<Dog> dogs = Arrays.asList(new Dog(), new Dog());
        System.out.println("Printing Dogs:");
        printAnimals(dogs);

        List<Cat> cats = Arrays.asList(new Cat(), new Cat());
        System.out.println("Printing Cats:");
        printAnimals(cats);

        List<Animal> mixed = Arrays.asList(new Dog(), new Cat());
        System.out.println("Printing Mixed Animals:");
        printAnimals(mixed);
    }
}
