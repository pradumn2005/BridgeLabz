import java.util.*;

class UniqueChars {
    static int myLength(String s) {
        int c=0;
        try {
            while(true) {
                s.charAt(c);
                c++;
            }
        } catch(Exception e) {}
        return c;
    }

    static char[] findUnique(String s) {
        int n=myLength(s);
        char temp[]=new char[n];
        int k=0;
        for(int i=0;i<n;i++) {
            char c=s.charAt(i);
            boolean found=false;
            for(int j=0;j<i;j++) {
                if(s.charAt(j)==c) {
                    found=true;
                    break;
                }
            }
            if(!found) temp[k++]=c;
        }
        char res[]=new char[k];
        for(int i=0;i<k;i++) res[i]=temp[i];
        return res;
    }

    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        char u[]=findUnique(s);
        System.out.print("Unique: ");
        for(char c:u) System.out.print(c+" ");
    }
}
