import java.util.*;

class VowelType {
    static String checkChar(char c) {
        if(c>='A' && c<='Z') c=(char)(c+32);
        if(c>='a' && c<='z') {
            if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u') return "Vowel";
            else return "Consonant";
        } else return "Not a Letter";
    }

    static String[][] makeTable(String s) {
        String res[][] = new String[s.length()][2];
        for(int i=0;i<s.length();i++) {
            res[i][0] = String.valueOf(s.charAt(i));
            res[i][1] = checkChar(s.charAt(i));
        }
        return res;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String table[][] = makeTable(s);
        System.out.println("Char\tType");
        for(int i=0;i<table.length;i++) {
            System.out.println(table[i][0]+"\t"+table[i][1]);
        }
    }
}
