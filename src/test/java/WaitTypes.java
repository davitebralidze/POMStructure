import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitTypes {

    WebDriver driver;

    //Setting implicit wait
    public void implicitWaitSetup() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    }

    public void explicitWaitSetup() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
    }

    public void fluentWaitSetup() {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(60))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);
    }

}
