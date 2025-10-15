
interface Exporter {
    void export();
    default void exportToJSON() { System.out.println("Exported to JSON"); }
}

class CSVExporter implements Exporter {
    public void export() { System.out.println("Exported to CSV"); }
}

public class ExportDemo {
    public static void main(String[] args) {
        CSVExporter e = new CSVExporter();
        e.export();
        e.exportToJSON();
    }
}
