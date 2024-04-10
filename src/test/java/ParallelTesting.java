import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParallelTesting {

    WebDriver driver;

    @Parameters("browser")
    @Test
    public void parallelTest(String browser) throws InterruptedException{

        System.out.println("Browser name: " + browser);
        System.out.println("Thread id: " + Thread.currentThread().getId());

        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
            Thread.sleep(5000);
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
            Thread.sleep(5000);
        } else {
            System.out.println("Browser not found");
        }

        driver.quit();

    }


}
