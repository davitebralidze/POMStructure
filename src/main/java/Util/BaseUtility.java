package Util;

import java.time.Duration;
import java.time.LocalTime;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import PageSteps.FirstPageSteps;
import static Util.PropertyLoader.returnConfigValue;

public class BaseUtility {

    private final String YELLOW = "\u001B[33m";
    private final String RESET = "\u001B[0m";
    private final String GREEN = "\033[92m";
    private LocalTime localTime;
    protected WebDriver driver;
    protected FirstPageSteps firstPageSteps;

    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] takeScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @BeforeSuite(groups = "smoke")
    public void allureCleaner() {
        localTime = LocalTime.now();
        System.out.println(YELLOW + "Process started at: " + localTime + RESET);
        Utils.deleteAllureReports();
    }

    @BeforeMethod(groups = "smoke")
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(returnConfigValue("url.base"));
        firstPageSteps = new FirstPageSteps(driver);
    }

    @AfterMethod(groups = "smoke")
    public void finish() {
        takeScreenshot();
        driver.quit();
    }

    @AfterSuite(groups = "smoke")
    public void showTestResults() throws InterruptedException {
        String port = Utils.startAllureServeAndGetPort();
        System.out.println(YELLOW + "Process ended at: " + LocalTime.now() + RESET);
        Duration duration = Duration.between(localTime, LocalTime.now());
        System.out.println(GREEN + "The testing process took " + duration.getSeconds()/3600 + " hours " +(duration.getSeconds()%3600)/60 + " minutes and " + (duration.getSeconds()%60) + " seconds" + RESET);
        Thread.sleep(5000);
        Utils.killAllureServer(port);

    }
}
