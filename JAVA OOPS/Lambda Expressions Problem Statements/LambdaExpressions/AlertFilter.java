import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class AlertFilter {

    public static void main(String[] args) {
        List<String> alerts = List.of(
            "CRITICAL: Patient Vitals Low",
            "INFO: Medication Reminder",
            "CRITICAL: System Failure",
            "WARNING: Battery Low",
            "INFO: Check-in Complete"
        );

        // Predicate 1: Filter only Critical alerts
        Predicate<String> isCritical = (alert) -> alert.startsWith("CRITICAL");
        
        // Predicate 2: Filter only Information alerts
        Predicate<String> isInfo = (alert) -> alert.startsWith("INFO");

        // Filter Critical alerts using the Predicate lambda
        List<String> criticalAlerts = alerts.stream()
            .filter(isCritical)
            .collect(Collectors.toList());

        System.out.println("--- All Alerts ---");
        alerts.forEach(System.out::println);

        System.out.println("\n--- Critical Alerts Only (Admin View) ---");
        criticalAlerts.forEach(System.out::println);

        // Filter Info alerts using the Predicate lambda
        List<String> infoAlerts = alerts.stream()
            .filter(isInfo)
            .collect(Collectors.toList());
            
        System.out.println("\n--- Info Alerts Only (Nurse View) ---");
        infoAlerts.forEach(System.out::println);
    }
}
