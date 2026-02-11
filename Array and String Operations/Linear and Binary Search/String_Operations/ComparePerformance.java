public class ComparePerformance {
    public static void compareStringClasses() {
        int iterations = 1000000;
        String text = "hello";

        StringBuffer buffer = new StringBuffer();
        long startTimeBuffer = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            buffer.append(text);
        }
        long endTimeBuffer = System.nanoTime();
        long bufferDuration = endTimeBuffer - startTimeBuffer;

        StringBuilder builder = new StringBuilder();
        long startTimeBuilder = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            builder.append(text);
        }
        long endTimeBuilder = System.nanoTime();
        long builderDuration = endTimeBuilder - startTimeBuilder;

        System.out.println(bufferDuration);
        System.out.println(builderDuration);
    }

    public static void main(String[] args) {
        compareStringClasses();
    }
}
