import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.time.Month;
import java.util.HashMap;
import java.util.List;

public class DatePicker {

    public static void main(String[] args) throws InterruptedException {


        HashMap<String , Month> monthMap = new HashMap<String , Month>();

        monthMap.put("January" , Month.JANUARY);
        monthMap.put("February" , Month.FEBRUARY);
        monthMap.put("March" , Month.MARCH);
        monthMap.put("April" , Month.APRIL);
        monthMap.put("May" , Month.MAY);
        monthMap.put("June" , Month.JUNE);
        monthMap.put("July" , Month.JULY);
        monthMap.put("August" , Month.AUGUST);
        monthMap.put("September" , Month.SEPTEMBER);
        monthMap.put("October" , Month.OCTOBER);
        monthMap.put("November" , Month.NOVEMBER);
        monthMap.put("December" , Month.DECEMBER);

        String date = "5";
        String month = "June";
        String year = "2028";

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("https://jqueryui.com/datepicker/");
        driver.switchTo().frame(0);
        driver.findElement(By.xpath("//*[@id=\"datepicker\"]")).click();

        while (true) {

            String currentMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
            String currentYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();

            if (currentMonth.equals(month) && currentYear.equals(year)) {
                break;
            }

            driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();

        }

        List<WebElement> listOfDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//td"));

        for (WebElement dt : listOfDates) {
            if (dt.getText().equals(date)) {
                dt.click();
                break;
            }
        }

        driver.quit();

    }

}