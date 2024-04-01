package Util;

import java.time.Duration;
import java.time.LocalTime;
import java.util.logging.Logger;

import io.qameta.allure.Attachment;
import jdk.jshell.execution.Util;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import PageSteps.FirstPageSteps;

public class BaseUtility {

    private final String YELLOW = "\u001B[33m";
    private final String RESET = "\u001B[0m";
    private final String GREEN = "\033[92m";
    private LocalTime localTime;
    protected WebDriver driver;
    protected PropertyLoader propertyLoader;
    protected FirstPageSteps firstPageSteps;
    protected Logger logger = Logger.getLogger(BaseUtility.class.getName());

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
    @Parameters({"browser", "environment"})
    public void setup(final String browser, final String environment) {
        if(browser.equals("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equals("firefox")) {
            driver = new FirefoxDriver();
        } else {
            logger.severe("Such browser is not supported");
            System.exit(0);
        }
        propertyLoader = new PropertyLoader(environment);
        driver.manage().window().maximize();
        driver.get(propertyLoader.returnConfigValue("url.base"));
        firstPageSteps = new FirstPageSteps(driver);
    }

    @AfterMethod(groups = "smoke")
    public void finish() {
        takeScreenshot();
        driver.quit();
    }

    @AfterSuite(groups = "smoke")
    public void showTestResults() throws InterruptedException {
//      String port = Utils.startAllureServeAndGetPort();
        System.out.println(YELLOW + "Process ended at: " + LocalTime.now() + RESET);
        Duration duration = Duration.between(localTime, LocalTime.now());
        System.out.println(GREEN + "The testing process took " + duration.getSeconds()/3600 + " hours " +(duration.getSeconds()%3600)/60 + " minutes and " + (duration.getSeconds()%60) + " seconds" + RESET);
//      Utils.killAllureServer(port, 5000);
        Utils.exportAllureResultAsHTML();
    }
}
