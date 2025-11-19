public class Pair<T, U> {

    private T first;
    private U second;

    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public U getSecond() {
        return second;
    }

    public static void main(String[] args) {
        Pair<String, Integer> student = new Pair<>("Amol", 20);
        System.out.println("Student Name: " + student.getFirst());
        System.out.println("Student Age: " + student.getSecond());

        Pair<Double, String> coordinates = new Pair<>(10.5, "Latitude");
        System.out.println("Coordinate: " + coordinates.getFirst() + ", Type: " + coordinates.getSecond());
    }
}
