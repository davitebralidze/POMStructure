import java.time.Month;
import java.util.HashMap;

public class MonthObject {
    public static void main(String[] args) {

        compareMonths("JULy" , "January");

    }

    static void compareMonths(String month1, String month2) {
        HashMap<String, Month> monthMap = new HashMap<String, Month>();

        monthMap.put("January", Month.JANUARY);
        monthMap.put("February", Month.FEBRUARY);
        monthMap.put("March", Month.MARCH);
        monthMap.put("April", Month.APRIL);
        monthMap.put("May", Month.MAY);
        monthMap.put("June", Month.JUNE);
        monthMap.put("July", Month.JULY);
        monthMap.put("August", Month.AUGUST);
        monthMap.put("September", Month.SEPTEMBER);
        monthMap.put("October", Month.OCTOBER);
        monthMap.put("November", Month.NOVEMBER);
        monthMap.put("December", Month.DECEMBER);

        month1 = month1.toLowerCase();
        month1 = month1.substring(0,1).toUpperCase() + month1.substring(1);

        month2 = month2.toLowerCase();
        month2 = month2.substring(0,1).toUpperCase() + month2.substring(1);

        Month m1 = monthMap.get(month1);
        Month m2 = monthMap.get(month2);

        if (m1 != null && m2 != null) {
            if (m1.compareTo(m2) < 0) {
                System.out.println(month1 + " is earlier than " + month2);
            } else if (m1.compareTo(m2) > 0) {
                System.out.println(month2 + " is earlier than " + month1);
            } else {
                System.out.println("You have provided same months");
            }
        }
    }

}
