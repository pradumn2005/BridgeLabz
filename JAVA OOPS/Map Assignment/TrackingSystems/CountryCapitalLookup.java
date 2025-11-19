import java.util.Map;
import java.util.TreeMap;

/**
 * Builds a simple Country -> Capital lookup system using a Map<String, String>.
 */
public class CountryCapitalLookup {

    public static void main(String[] args) {
        // 1. Add several country -> capital pairs
        Map<String, String> capitalMap = Map.of(
            "India", "New Delhi",
            "USA", "Washington D.C.",
            "Japan", "Tokyo",
            "Germany", "Berlin",
            "Brazil", "Brasília",
            "Canada", "Ottawa",
            "Australia", "Canberra",
            "China", "Beijing"
        );

        System.out.println("--- Country Capital Lookup System ---");

        // 2. Given a country input, lookup and print the capital.
        lookupCapital(capitalMap, "India");
        lookupCapital(capitalMap, "France");
        lookupCapital(capitalMap, "Japan");

        // 3. Print all countries in alphabetical order, along with capitals.
        // Use a TreeMap to get a map sorted by key (Country name)
        Map<String, String> sortedMap = new TreeMap<>(capitalMap);
        System.out.println("\n--- All Countries and Capitals (Alphabetical) ---");
        sortedMap.forEach((country, capital) ->
            System.out.println(country + " -> " + capital)
        );
    }

    public static void lookupCapital(Map<String, String> map, String country) {
        String capital = map.get(country);
        System.out.print("\nLooking up '" + country + "': ");
        if (capital != null) {
            System.out.println("Capital is " + capital);
        } else {
            System.out.println("Unknown country.");
        }
    }
}
