import java.util.*;

class FreqChars {
    static String[][] freqTable(String s) {
        int freq[]=new int[256];
        for(int i=0;i<s.length();i++) freq[s.charAt(i)]++;
        String res[][]=new String[s.length()][2];
        int k=0;
        for(int i=0;i<s.length();i++) {
            char c=s.charAt(i);
            if(freq[c]>0) {
                res[k][0]=String.valueOf(c);
                res[k][1]=String.valueOf(freq[c]);
                freq[c]=0;
                k++;
            }
        }
        String out[][]=new String[k][2];
        for(int i=0;i<k;i++) out[i]=res[i];
        return out;
    }

    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        String arr[][]=freqTable(s);
        System.out.println("Char\tFreq");
        for(int i=0;i<arr.length;i++) {
            System.out.println(arr[i][0]+"\t"+arr[i][1]);
        }
    }
}
