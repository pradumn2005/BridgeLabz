import java.util.Scanner;
class SquareSide {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double perimeter;
        perimeter = sc.nextDouble();
        double side = perimeter / 4;
        System.out.println("The length of the side is " + side + " whose perimeter is " + perimeter);
    }
}

