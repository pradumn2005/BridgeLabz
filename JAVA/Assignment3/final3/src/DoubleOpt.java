import java.util.Scanner;
class DoubleOpt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a, b, c;
        a = sc.nextDouble();
        b = sc.nextDouble();
        c = sc.nextDouble();
        double res1 = a + b * c;
        double res2 = a * b + c;
        double res3 = c + a / b;
        double res4 = a % b + c;
        System.out.println("The results of Double Operations are " + res1 + ", " + res2 + ", " + res3 + ", and " + res4);
    }
}
