package Util;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import PageSteps.FirstPageSteps;
import static Util.PropertyLoader.returnConfigValue;

public class BaseUtility {

    protected WebDriver driver;
    protected FirstPageSteps firstPageSteps;

    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] takeScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @BeforeSuite(groups = "smoke")
    public void allureCleaner() {
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

}
