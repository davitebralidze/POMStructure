import java.time.ZonedDateTime;
import java.util.TimeZone;

public class WorkingWithTime {

    public static void main(String[] args) {

        TimeZone timeZone = TimeZone.getDefault();

        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        String offsetFromUTC = zonedDateTime.getOffset().toString();

        System.out.println("Current time zone is " + offsetFromUTC + " " + timeZone.getID());

    }

}
