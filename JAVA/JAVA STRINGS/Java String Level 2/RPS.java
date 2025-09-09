import java.util.*;

class RPS {
    static String compChoice() {
        int n=(int)(Math.random()*3);
        if(n==0) return "rock";
        if(n==1) return "paper";
        return "scissors";
    }

    static int winner(String u,String c) {
        if(u.equals(c)) return 0;
        if(u.equals("rock") && c.equals("scissors")) return 1;
        if(u.equals("paper") && c.equals("rock")) return 1;
        if(u.equals("scissors") && c.equals("paper")) return 1;
        return -1;
    }

    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        int games=sc.nextInt();
        int uw=0,cw=0;
        for(int i=1;i<=games;i++) {
            String u=sc.next();
            String c=compChoice();
            int res=winner(u,c);
            if(res==1) uw++;
            else if(res==-1) cw++;
            System.out.println("Game "+i+": User="+u+" Computer="+c);
        }
        System.out.println("User wins: "+uw);
        System.out.println("Computer wins: "+cw);
        System.out.println("User %: "+(uw*100.0/games));
        System.out.println("Computer %: "+(cw*100.0/games));
    }
}

