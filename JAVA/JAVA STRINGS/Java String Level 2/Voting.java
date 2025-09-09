import java.util.*;

class Voting {
    static int[] makeAges(int n) {
        int arr[] = new int[n];
        Random r=new Random();
        for(int i=0;i<n;i++) arr[i]=10+r.nextInt(90);
        return arr;
    }

    static String[][] canVote(int arr[]) {
        String res[][] = new String[arr.length][2];
        for(int i=0;i<arr.length;i++) {
            res[i][0]=String.valueOf(arr[i]);
            if(arr[i]<0) res[i][1]="false";
            else if(arr[i]>=18) res[i][1]="true";
            else res[i][1]="false";
        }
        return res;
    }

    public static void main(String args[]) {
        int arr[]=makeAges(10);
        String res[][]=canVote(arr);
        System.out.println("Age\tCanVote");
        for(int i=0;i<res.length;i++) {
            System.out.println(res[i][0]+"\t"+res[i][1]);
        }
    }
}
