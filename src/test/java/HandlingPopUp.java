import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HandlingPopUp {
    public static void main(String[] args) throws InterruptedException {

        String URL = "https://the-internet.herokuapp.com/javascript_alerts";
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get(URL);
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[2]/button")).click();

        //Alert alert = driver.switchTo().alert();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();

        Thread.sleep(5000);
        driver.quit();

    }
}
