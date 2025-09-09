import java.util.*;

class SubStr {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int st = sc.nextInt();
        int en = sc.nextInt();

        String sub1 = "";
        for(int i=st; i<en; i++) {
            sub1 = sub1 + s.charAt(i);
        }

        String sub2 = s.substring(st,en);

        System.out.println("User substring: " + sub1);
        System.out.println("Inbuilt substring: " + sub2);
        System.out.println("Same or not: " + sub1.equals(sub2));
    }
}
