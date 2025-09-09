import java.util.*;

class StringLength {
    static int findLen(String s) {
        int c = 0;
        try {
            while(true) {
                s.charAt(c);
                c++;
            }
        } catch(Exception e) {
            return c;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int l1 = findLen(s);
        int l2 = s.length();
        System.out.println("User length: " + l1);
        System.out.println("Inbuilt length: " + l2);
    }
}
