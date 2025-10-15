
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
interface DateUtils {
    static String format(LocalDate date, String pattern) {
        return date.format(DateTimeFormatter.ofPattern(pattern));
    }
}

public class DateDemo {
    public static void main(String[] args) {
        System.out.println(DateUtils.format(LocalDate.now(), "dd-MM-yyyy"));
    }
}
