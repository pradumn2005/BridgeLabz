import java.util.*;

class ToCharArr {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        char a1[] = new char[s.length()];
        for(int i=0;i<s.length();i++) {
            a1[i] = s.charAt(i);
        }

        char a2[] = s.toCharArray();

        boolean same = true;
        if(a1.length != a2.length) same=false;
        else {
            for(int i=0;i<a1.length;i++) {
                if(a1[i] != a2[i]) {
                    same=false;
                    break;
                }
            }
        }
        System.out.println("Arrays same: " + same);
    }
}
