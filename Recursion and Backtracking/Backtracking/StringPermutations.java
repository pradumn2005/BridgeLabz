public class StringPermutations {
    public static void permute(String chosen, String remaining) {
        if (remaining.length() == 0) {
            System.out.println(chosen);
            return;
        }

        for (int i = 0; i < remaining.length(); i++) {
            char ch = remaining.charAt(i);
            String newRemaining = remaining.substring(0, i) + remaining.substring(i + 1);
            permute(chosen + ch, newRemaining);
        }
    }

    public static void main(String[] args) {
        String input = "ABC";
        System.out.println("Permutations of " + input + ":");
        permute("", input);
    }
}
