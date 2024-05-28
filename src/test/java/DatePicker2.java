import Util.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Month;
import java.util.HashMap;
import java.util.List;

public class DatePicker2 {
    public static void main(String[] args) throws InterruptedException {

        String desiredYear = "2025";
        String desiredMonth = "February";
        String desiredDate = "23";

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");
        WebElement iFrame = driver.findElement(By.xpath("//*[@id=\"frame-one796456169\"]"));
        Utils.scrollToASpecificElement(driver, iFrame);
        driver.switchTo().frame("frame-one796456169");
        driver.findElement(By.xpath("//*[@id=\"q4\"]/span")).click();

        //Select Year
        WebElement yerDropDown = driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/select"));
        Select selectYer = new Select(yerDropDown);
        selectYer.selectByVisibleText(desiredYear);

        //Select Month
        while (true) {
            Month expectedMonth = convertMonth(desiredMonth);
            Month displayedMont = convertMonth(driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/span")).getText());

            int result = expectedMonth.compareTo(displayedMont);

            if (result < 0) {
                driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[1]/span")).click();
            } else if (result > 0) {
                driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[2]/span")).click();
            } else {
                break;
            }
        }

        //Select a date
        List<WebElement> allDates = driver.findElements(By.xpath("//*[@id=\"ui-datepicker-div\"]/table//tbody//tr//td//a"));

        for (WebElement dt : allDates) {
            if(dt.getText().equals(desiredDate)) {
                dt.click();
                break;
            }
        }

        Thread.sleep(5000);
        driver.quit();

    }

    static Month convertMonth(String month) {
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

        month = month.toLowerCase();
        month = month.substring(0, 1).toUpperCase() + month.substring(1);

        Month monthObject = monthMap.get(month);

        return monthObject;
    }

}
