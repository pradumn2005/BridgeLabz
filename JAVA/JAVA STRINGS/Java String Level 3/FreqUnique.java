import java.util.*;

class FreqUnique {
    static char[] uniqueChars(String s) {
        int n=s.length(),k=0;
        char temp[]=new char[n];
        for(int i=0;i<n;i++) {
            char c=s.charAt(i);
            boolean f=false;
            for(int j=0;j<i;j++) if(s.charAt(j)==c) f=true;
            if(!f) temp[k++]=c;
        }
        char res[]=new char[k];
        for(int i=0;i<k;i++) res[i]=temp[i];
        return res;
    }

    static String[][] freq(String s) {
        int freq[]=new int[256];
        for(int i=0;i<s.length();i++) freq[s.charAt(i)]++;
        char uniq[]=uniqueChars(s);
        String arr[][]=new String[uniq.length][2];
        for(int i=0;i<uniq.length;i++) {
            arr[i][0]=String.valueOf(uniq[i]);
            arr[i][1]=String.valueOf(freq[uniq[i]]);
        }
        return arr;
    }

    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        String arr[][]=freq(s);
        System.out.println("Char\tFreq");
        for(int i=0;i<arr.length;i++) {
            System.out.println(arr[i][0]+"\t"+arr[i][1]);
        }
    }
}
