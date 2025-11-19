public class Box<T> {

    private T value;

    public void set(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }

    public static void main(String[] args) {
        Box<Integer> integerBox = new Box<>();
        integerBox.set(123);
        System.out.println("Integer value: " + integerBox.get());

        Box<String> stringBox = new Box<>();
        stringBox.set("Hello Generics");
        System.out.println("String value: " + stringBox.get());

        Box<Double> doubleBox = new Box<>();
        doubleBox.set(3.14159);
        System.out.println("Double value: " + doubleBox.get());
    }
}
