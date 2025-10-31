public class ShoppingCartPrice {
    public static void main(String[] args) {
        String[] prices = {"250", "499", "99", "abc", "150"};
        int total = 0;

        System.out.println("Processing prices...");

        for (String price : prices) {
            try {
                int value = Integer.parseInt(price);
                total += value;
                System.out.println("Added: " + value);
            } catch (NumberFormatException e) {
                System.out.println("Skipped invalid price: " + price);
            }
        }

        System.out.println("Total Price: " + total);
    }
}
