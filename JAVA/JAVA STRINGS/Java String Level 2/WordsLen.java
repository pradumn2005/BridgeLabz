import java.util.*;

class WordsLen {
    static int findLen(String s) {
        int c=0;
        try {
            while(true) {
                s.charAt(c); c++;
            }
        } catch(Exception e) {
            return c;
        }
    }

    static String[] splitWords(String s) {
        int n = findLen(s);
        int spaces=0;
        for(int i=0;i<n;i++) if(s.charAt(i)==' ') spaces++;
        String arr[] = new String[spaces+1];
        int idx=0; String w="";
        for(int i=0;i<n;i++) {
            char ch=s.charAt(i);
            if(ch==' ') { arr[idx]=w; idx++; w=""; }
            else w+=ch;
        }
        arr[idx]=w;
        return arr;
    }

    static String[][] wordLen(String[] arr) {
        String res[][] = new String[arr.length][2];
        for(int i=0;i<arr.length;i++) {
            res[i][0]=arr[i];
            res[i][1]=String.valueOf(findLen(arr[i]));
        }
        return res;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String arr[] = splitWords(line);
        String res[][] = wordLen(arr);
        System.out.println("Word\tLength");
        for(int i=0;i<res.length;i++) {
            System.out.println(res[i][0]+"\t"+Integer.parseInt(res[i][1]));
        }
    }
}
