import java.util.Scanner;
class TotalPrice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double unitPrice;
        int quantity;
        unitPrice = sc.nextDouble();
        quantity = sc.nextInt();
        double total = unitPrice * quantity;
        System.out.println("The total purchase price is INR " + total + " if the quantity " + quantity + " and unit price is INR " + unitPrice);
    }
}
