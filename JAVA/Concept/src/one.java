import java.util.Scanner;

public class TravelDistanceCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String travelerName;
        double distanceFromStartToVia;
        double distanceFromViaToFinal;
        double totalTravelDistance;

        System.out.print("Enter your name: ");
        travelerName = input.nextLine();

        System.out.print("Enter distance from Start City to Via City (in km): ");
        distanceFromStartToVia = input.nextDouble();

        System.out.print("Enter distance from Via City to Final City (in km): ");
        distanceFromViaToFinal = input.nextDouble();

        totalTravelDistance = distanceFromStartToVia + distanceFromViaToFinal;

        System.out.println("\nTraveler: " + travelerName);
        System.out.println("Total distance traveled = " + totalTravelDistance + " km");

        input.close();
    }
}
