import java.util.*;

class VowelCount {
    static boolean isVowel(char c) {
        c = Character.toLowerCase(c);
        return (c=='a'||c=='e'||c=='i'||c=='o'||c=='u');
    }

    static int[] countVC(String s) {
        int v=0,c=0;
        for(int i=0;i<s.length();i++) {
            char ch=s.charAt(i);
            if(Character.isLetter(ch)) {
                if(isVowel(ch)) v++;
                else c++;
            }
        }
        return new int[]{v,c};
    }

    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        int arr[]=countVC(s);
        System.out.println("Vowels: "+arr[0]);
        System.out.println("Consonants: "+arr[1]);
    }
}
