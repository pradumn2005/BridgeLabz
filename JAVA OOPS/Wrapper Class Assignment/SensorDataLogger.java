import java.util.ArrayList;

public class SensorDataLogger {

    private static ArrayList<Double> temperatureLog = new ArrayList<>();

    public static void logTemperature(Double temp) {
        System.out.println("Logging temperature: " + temp);
        temperatureLog.add(temp);
    }

    public static double getAverageTemperature() {
        double sum = 0;
        for (double temp : temperatureLog) {
            sum += temp;
        }
        return sum / temperatureLog.size();
    }

    public static void main(String[] args) {
        double primitiveTemp = 25.5;
        Double wrapperTemp = Double.valueOf(26.2);

        logTemperature(primitiveTemp);
        logTemperature(wrapperTemp);
        logTemperature(27.1);

        System.out.println("Logged data: " + temperatureLog);
        System.out.println("Average temperature: " + getAverageTemperature());
    }
}
