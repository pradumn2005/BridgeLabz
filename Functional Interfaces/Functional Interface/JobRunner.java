
public class JobRunner {
    public static void main(String[] args) {
        Runnable job = () -> System.out.println("Job Running...");
        new Thread(job).start();
    }
}
