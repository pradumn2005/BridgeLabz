import java.util.*;

class Palindrome {
    static boolean check1(String s) {
        int st=0,en=s.length()-1;
        while(st<en) {
            if(s.charAt(st)!=s.charAt(en)) return false;
            st++; en--;
        }
        return true;
    }

    static boolean check2(String s,int st,int en) {
        if(st>=en) return true;
        if(s.charAt(st)!=s.charAt(en)) return false;
        return check2(s,st+1,en-1);
    }

    static String reverse(String s) {
        String r="";
        for(int i=s.length()-1;i>=0;i--) r+=s.charAt(i);
        return r;
    }

    static boolean check3(String s) {
        return s.equals(reverse(s));
    }

    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        System.out.println("Logic1: "+check1(s));
        System.out.println("Logic2: "+check2(s,0,s.length()-1));
        System.out.println("Logic3: "+check3(s));
    }
}
