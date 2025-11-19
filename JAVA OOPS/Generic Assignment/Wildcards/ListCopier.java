import java.util.ArrayList;
import java.util.List;

public class ListCopier {

    public static void copyList(List<? super Number> dest, List<? extends Number> src) {
        for (Number number : src) {
            dest.add(number);
        }
    }

    public static void main(String[] args) {
        List<Integer> sourceInt = List.of(10, 20, 30);
        List<Number> destinationNumber = new ArrayList<>();
        
        copyList(destinationNumber, sourceInt);
        System.out.println("Destination list (Numbers): " + destinationNumber);

        List<Object> destinationObject = new ArrayList<>();
        List<Double> sourceDouble = List.of(1.1, 2.2, 3.3);
        
        copyList(destinationObject, sourceDouble);
        System.out.println("Destination list (Objects): " + destinationObject);
    }
}
