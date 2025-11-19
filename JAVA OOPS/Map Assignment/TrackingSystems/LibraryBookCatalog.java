import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Manages a library catalog using a Map<String, String> for ISBN -> Title.
 */
public class LibraryBookCatalog {

    public static void main(String[] args) {
        Map<String, String> bookCatalog = new HashMap<>();

        // 1. Add several books
        bookCatalog.put("978-0134685991", "Effective Java");
        bookCatalog.put("978-1617293563", "Spring in Action");
        bookCatalog.put("978-0321356680", "Code Complete");
        bookCatalog.put("978-1234567890", "The Great Java Book");

        System.out.println("--- Initial Catalog ---");
        System.out.println(bookCatalog);

        // 2. Search by ISBN
        searchByISBN(bookCatalog, "978-0134685991");
        searchByISBN(bookCatalog, "999-9999999999");

        // 3. Remove books
        String isbnToRemove = "978-0321356680";
        bookCatalog.remove(isbnToRemove);
        System.out.println("\nRemoved ISBN: " + isbnToRemove);

        // 4. Print all ISBNs + titles sorted by ISBN.
        // Use a TreeMap to get a map sorted by key (ISBN)
        Map<String, String> sortedCatalog = new TreeMap<>(bookCatalog);
        System.out.println("\n--- Catalog Sorted by ISBN ---");
        sortedCatalog.forEach((isbn, title) ->
            System.out.println("ISBN: " + isbn + ", Title: " + title)
        );

        // Extended Task: Search by Title
        searchByTitle(bookCatalog, "Spring in Action");
        searchByTitle(bookCatalog, "The Little Java Book");
    }

    public static void searchByISBN(Map<String, String> catalog, String isbn) {
        String title = catalog.get(isbn);
        System.out.print("\nSearching for ISBN " + isbn + ": ");
        if (title != null) {
            System.out.println("Found Title: " + title);
        } else {
            System.out.println("Book not found.");
        }
    }

    // Extended Task: Search by Title
    public static void searchByTitle(Map<String, String> catalog, String title) {
        System.out.print("\nSearching for Title '" + title + "': ");
        String foundIsbn = null;
        // Iterate the map to find a matching title
        for (Map.Entry<String, String> entry : catalog.entrySet()) {
            if (entry.getValue().equalsIgnoreCase(title)) {
                foundIsbn = entry.getKey();
                break;
            }
        }

        if (foundIsbn != null) {
            System.out.println("Found ISBN: " + foundIsbn);
        } else {
            System.out.println("Book not found.");
        }
    }
}
