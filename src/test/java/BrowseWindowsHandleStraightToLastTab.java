import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BrowseWindowsHandleStraightToLastTab {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.get("https://qaplayground.dev/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("/html/body/main/div[3]/a[6]/div/p")).click();
        driver.findElement(By.xpath("//*[@id=\"open\"]")).click();

        Set<String> windows = driver.getWindowHandles();
        List<String> windowList = new ArrayList<>(windows);


        for (String handle : windows) {
            driver.switchTo().window(handle);
        }

        driver.switchTo().window(windowList.get(windowList.size() - 1));
        System.out.println(driver.findElement(By.xpath("//*[@id=\"wrapper\"]/h1")).getText());

        driver.close();

        driver.switchTo().window((String) windows.toArray()[0]);

        driver.quit();


    }
}
