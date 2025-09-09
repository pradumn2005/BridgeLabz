import java.util.*;

class WindChillTemperature {
    static double calculateWindChill(double temp, double windSpeed) {
        return 35.74 + 0.6215 * temp + (0.4275 * temp - 35.75) * Math.pow(windSpeed, 0.16);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        double t = sc.nextDouble();
        double v = sc.nextDouble();
        System.out.println(calculateWindChill(t, v));
    }
}
