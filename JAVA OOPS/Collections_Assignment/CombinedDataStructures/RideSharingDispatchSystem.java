import java.util.*;

/**
 * Ride-Sharing Dispatch System demonstrating Queue, Set, List, and PriorityQueue.
 */
class RideRequest implements Comparable<RideRequest> {
    String id;
    int urgency; // Higher is more urgent/closer to driver
    public RideRequest(String id, int urgency) { this.id = id; this.urgency = urgency; }
    @Override public String toString() { return "Request:" + id + " (P" + urgency + ")"; }
    // Prioritize by urgency (higher first)
    @Override public int compareTo(RideRequest other) { return Integer.compare(other.urgency, this.urgency); }
}
class Driver {
    String driverId;
    public Driver(String driverId) { this.driverId = driverId; }
    @Override public String toString() { return "Driver:" + driverId; }
    @Override public boolean equals(Object o) { if (this == o) return true; if (o == null || getClass() != o.getClass()) return false; Driver driver = (Driver) o; return driverId.equals(driver.driverId); }
    @Override public int hashCode() { return driverId.hashCode(); }
}
class Ride {
    String rideId;
    String driverId;
    public Ride(String rideId, String driverId) { this.rideId = rideId; this.driverId = driverId; }
    @Override public String toString() { return "COMPLETED Ride:" + rideId + " by " + driverId; }
}

public class RideSharingDispatchSystem {
    private Queue<RideRequest> normalQueue = new LinkedList<>();
    private PriorityQueue<RideRequest> priorityQueue = new PriorityQueue<>();
    private Set<Driver> availableDrivers = new HashSet<>();
    private List<Ride> completedRides = new ArrayList<>();

    public void addDriver(Driver driver) { availableDrivers.add(driver); }
    
    // 1. Add incoming ride requests
    public void addRequest(RideRequest request) {
        if (request.urgency > 4) { // Urgency >= 5 is high priority
            priorityQueue.add(request);
            System.out.println("-> High Priority request added: " + request);
        } else {
            normalQueue.add(request);
            System.out.println("-> Normal request added: " + request);
        }
    }

    // 2. Assign drivers from the available pool.
    public void assignRides() {
        System.out.println("\n--- Assigning Rides ---");
        Driver driver = availableDrivers.stream().findFirst().orElse(null);
        if (driver == null) {
            System.out.println("No drivers available.");
            return;
        }
        availableDrivers.remove(driver); // Driver is now busy

        RideRequest requestToAssign;
        if (!priorityQueue.isEmpty()) { // 4. Handle high-priority requests first.
            requestToAssign = priorityQueue.poll();
            System.out.print("PRIORITY: ");
        } else if (!normalQueue.isEmpty()) {
            requestToAssign = normalQueue.poll();
            System.out.print("NORMAL: ");
        } else {
            System.out.println("No pending requests.");
            availableDrivers.add(driver); // Driver remains available
            return;
        }

        System.out.println(driver + " assigned to " + requestToAssign);
        // 3. Move completed rides to the ride history list (simulated immediately after assignment)
        completedRides.add(new Ride(requestToAssign.id, driver.driverId));
        System.out.println("  Ride completed and driver " + driver.driverId + " is now available again.");
        availableDrivers.add(driver); // Driver becomes available again
    }

    public static void main(String[] args) {
        RideSharingDispatchSystem system = new RideSharingDispatchSystem();

        // Setup
        system.addDriver(new Driver("D10"));
        system.addDriver(new Driver("D20"));
        
        // 1. Add requests
        system.addRequest(new RideRequest("R01", 3)); // Normal
        system.addRequest(new RideRequest("R02", 5)); // Priority
        system.addRequest(new RideRequest("R03", 4)); // Normal
        system.addRequest(new RideRequest("R04", 6)); // Priority

        // 2. & 4. Assign rides (Priority first)
        system.assignRides(); // Should take R04 (P6)
        system.assignRides(); // Should take R02 (P5)
        system.assignRides(); // Should take R01 (P3)
        system.assignRides(); // Should take R03 (P4)
        system.assignRides(); // No requests

        System.out.println("\n--- Completed Rides History ---");
        system.completedRides.forEach(System.out::println);
    }
}
