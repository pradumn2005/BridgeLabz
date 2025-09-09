import java.util.*;

class CompareStrings {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();

        boolean same = true;
        if(s1.length() != s2.length()) {
            same = false;
        } else {
            for(int i=0; i<s1.length(); i++) {
                if(s1.charAt(i) != s2.charAt(i)) {
                    same = false;
                    break;
                }
            }
        }
        System.out.println("User compare: " + same);
        System.out.println("Equals method: " + s1.equals(s2));
    }
}
