import java.util.*;

class ArrIndex {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String arr[] = new String[n];
        for(int i=0;i<n;i++) {
            arr[i] = sc.next();
        }
        try {
            System.out.println(arr[n]);
        } catch(Exception e) {
            System.out.println("ArrayIndexOutOfBounds handled");
        }
    }
}
