import java.util.*;

class TrimSpaces {
    static int[] findBounds(String s) {
        int st=0,en=s.length()-1;
        while(st<s.length() && s.charAt(st)==' ') st++;
        while(en>=0 && s.charAt(en)==' ') en--;
        return new int[]{st,en+1};
    }

    static String mySub(String s,int st,int en) {
        String res="";
        for(int i=st;i<en;i++) res+=s.charAt(i);
        return res;
    }

    static boolean compare(String a,String b) {
        if(a.length()!=b.length()) return false;
        for(int i=0;i<a.length();i++) if(a.charAt(i)!=b.charAt(i)) return false;
        return true;
    }

    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        int b[]=findBounds(s);
        String t1=mySub(s,b[0],b[1]);
        String t2=s.trim();
        System.out.println("User trim: "+t1);
        System.out.println("Inbuilt trim: "+t2);
        System.out.println("Same: "+compare(t1,t2));
    }
}
