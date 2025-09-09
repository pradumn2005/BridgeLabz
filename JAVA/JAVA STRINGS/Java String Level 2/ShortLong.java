import java.util.*;

class ShortLong {
    static int findLen(String s) {
        int c=0;
        try { while(true){ s.charAt(c); c++; } }
        catch(Exception e) { return c; }
    }

    static String[] splitWords(String s) {
        int n=findLen(s),spaces=0;
        for(int i=0;i<n;i++) if(s.charAt(i)==' ') spaces++;
        String arr[]=new String[spaces+1];
        int idx=0; String w="";
        for(int i=0;i<n;i++) {
            char ch=s.charAt(i);
            if(ch==' ') { arr[idx]=w; idx++; w=""; }
            else w+=ch;
        }
        arr[idx]=w;
        return arr;
    }

    static String[] shortestLongest(String[] arr) {
        String min=arr[0],max=arr[0];
        for(int i=0;i<arr.length;i++) {
            if(findLen(arr[i])<findLen(min)) min=arr[i];
            if(findLen(arr[i])>findLen(max)) max=arr[i];
        }
        return new String[]{min,max};
    }

    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        String line=sc.nextLine();
        String arr[]=splitWords(line);
        String ans[]=shortestLongest(arr);
        System.out.println("Shortest: "+ans[0]);
        System.out.println("Longest: "+ans[1]);
    }
}
