import Util.Utils;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.testng.asserts.SoftAssert;

import javax.xml.crypto.Data;
import java.time.Duration;
import java.util.List;

public class Test {
    public static void main(String[] args) throws InterruptedException {



        String URL = "https://flatrocktech.com/";
        WebDriver driver = new ChromeDriver();
        Actions actions = new Actions(driver);
        SoftAssert softAssert = new SoftAssert();
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get(URL);
        driver.manage().window().maximize();


        WebElement element = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//*[@id=\"__next\"]/div[1]/main/div[5]/div[2]/div/div[2]/div/div[1]/div[1]/div[2]/div")));

        Utils.scrollToASpecificElement(driver, element);
        Utils.jsHover(driver, element);




        List<WebElement> elements = explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"__next\"]/div[1]/main/div[5]/div[2]/div/div[2]/div/div[1]/div[1]/div[2]/div/div[1]/div[2]/div/ul//a")));

        for (WebElement link : elements) {
            String elementLink = link.getAttribute("href");
            Response response = RestAssured.get(URL);
            int responseCode = response.getStatusCode();
            softAssert.assertTrue(responseCode < 400, elementLink + " is not working");
            System.out.println(responseCode);
        }
        softAssert.assertAll();
        driver.quit();
    }
}
