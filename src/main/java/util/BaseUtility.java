package util;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pageElements.FirstPageElements;
import pageSteps.FirstPageSteps;

import static util.PropertyLoader.returnConfigValue;

public class BaseUtility  {

    protected static WebDriver driver;
    protected FirstPageSteps firstPageSteps;
    protected FirstPageElements firstPageElements;


    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] takeScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(returnConfigValue("url.base"));
        firstPageSteps = new FirstPageSteps(driver);
    }

    @AfterMethod
    public void finish() {
        driver.quit();
    }

}
