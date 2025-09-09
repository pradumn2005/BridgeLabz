import java.util.*;

class NumFormat {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        try {
            int n = Integer.parseInt(s);
            System.out.println(n);
        } catch(Exception e) {
            System.out.println("NumberFormatException handled");
        }
    }
}
