import java.util.*;

class ToLower {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        String low = "";
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if(c>='A' && c<='Z') {
                c = (char)(c+32);
            }
            low = low + c;
        }

        System.out.println("User lower: " + low);
        System.out.println("Inbuilt lower: " + s.toLowerCase());
        System.out.println("Same or not: " + low.equals(s.toLowerCase()));
    }
}
