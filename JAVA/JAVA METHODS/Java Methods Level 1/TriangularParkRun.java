import java.util.*;

class TriangularParkRun {
    static int roundsFor5km(double a, double b, double c) {
        double per = a + b + c;
        double need = 5000.0 / per;
        return (int) Math.ceil(need);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();
        System.out.println(roundsFor5km(a, b, c));
    }
}
