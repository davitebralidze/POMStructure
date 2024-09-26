package Util;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalTime;
import java.util.logging.Logger;

import WebDriverManager.WebDriverManager;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

    //TODO Check this code
    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] takeScreenshotOfSpecificElement(WebElement element) {return (element.getScreenshotAs(OutputType.BYTES));}

    @BeforeSuite(groups = "smoke")
    public void allureCleaner() throws IOException {
        localTime = LocalTime.now();
        System.out.println(YELLOW + "Process started at: " + localTime + RESET);
        Utils.deleteAllureReports();
        Utils.incrementCellA1();
    }

    @BeforeMethod(groups = "smoke")
    @Parameters({"browser", "environment"})
    public void setup(final String browser, final String environment) {

        driver = WebDriverManager.getInstance(browser).getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));


        propertyLoader = new PropertyLoader(environment);
        driver.get(propertyLoader.returnConfigValue("url.base"));
        //Setting implicit wait
        firstPageSteps = new FirstPageSteps(driver);
    }

    @AfterMethod(groups = "smoke")
    public void finish() {
        takeScreenshot();
        WebDriverManager.quitBrowser();
    }

    @AfterSuite(groups = "smoke")
    public void showTestResults() throws IOException {
        System.out.println(YELLOW + "Process ended at: " + LocalTime.now() + RESET);
        Duration duration = Duration.between(localTime, LocalTime.now());
        System.out.println(GREEN + "The testing process took " + duration.getSeconds()/3600 + " hours " +(duration.getSeconds()%3600)/60 + " minutes and " + (duration.getSeconds()%60) + " seconds" + RESET);
        Utils.exportAllureResultAsHTML();
    }
}
