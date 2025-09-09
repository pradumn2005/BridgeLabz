import java.util.*;

class ToUpper {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        String up = "";
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if(c>='a' && c<='z') {
                c = (char)(c-32);
            }
            up = up + c;
        }

        System.out.println("User upper: " + up);
        System.out.println("Inbuilt upper: " + s.toUpperCase());
        System.out.println("Same or not: " + up.equals(s.toUpperCase()));
    }
}
