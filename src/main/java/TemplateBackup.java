import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;


public class TemplateBackup {
    public static void main(String[] arg){

        var a = LocalDateTime.now().minusMonths(3);
        var b = LocalDateTime.now();
        while (a.isBefore(b)){
            System.out.println(a.format(DateTimeFormatter.ofPattern("YYYY-MM-DD")));
            a=a.plusDays(1);
        }

    }
}

