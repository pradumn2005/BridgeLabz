import java.util.*;

class IllegalArg {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        try {
            System.out.println(s.substring(5,2));
        } catch(Exception e) {
            System.out.println("IllegalArgumentException handled");
        }
    }
}
