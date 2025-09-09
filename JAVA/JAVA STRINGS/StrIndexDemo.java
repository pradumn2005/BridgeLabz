import java.util.*;

class StrIndexDemo {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        try {
            System.out.println(s.charAt(s.length()));
        } catch(Exception e) {
            System.out.println("StringIndexOutOfBounds handled");
        }
    }
}
