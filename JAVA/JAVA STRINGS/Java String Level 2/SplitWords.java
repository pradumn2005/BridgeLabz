import java.util.*;

class SplitWords {
    static int findLen(String s) {
        int c=0;
        try {
            while(true) {
                s.charAt(c);
                c++;
            }
        } catch(Exception e) {
            return c;
        }
    }

    static String[] mySplit(String s) {
        int n = findLen(s);
        int spaces = 0;
        for(int i=0;i<n;i++) if(s.charAt(i)==' ') spaces++;
        String words[] = new String[spaces+1];
        int idx=0; String w="";
        for(int i=0;i<n;i++) {
            char ch = s.charAt(i);
            if(ch==' ') {
                words[idx]=w; idx++; w="";
            } else w+=ch;
        }
        words[idx]=w;
        return words;
    }

    static boolean same(String[] a, String[] b) {
        if(a.length!=b.length) return false;
        for(int i=0;i<a.length;i++) {
            if(!a[i].equals(b[i])) return false;
        }
        return true;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String arr1[] = mySplit(line);
        String arr2[] = line.split(" ");
        System.out.println("Same: " + same(arr1,arr2));
    }
}
