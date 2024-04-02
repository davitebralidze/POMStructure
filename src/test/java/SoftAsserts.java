import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class SoftAsserts {
    public static void main(String[] args) throws IOException {
        SoftAssert softAssert = new SoftAssert();

        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/AutomationPractice");
        List<WebElement> links = driver.findElements(By.cssSelector("li.gf-li a"));

        for (WebElement link : links) {
            String url = link.getAttribute("href");
            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setRequestMethod("HEAD");
            conn.connect();
            int responseCode = conn.getResponseCode();
            softAssert.assertTrue(responseCode < 400 ,
                    "The status code was greater than 400 for the link: " +
                            link.getAttribute("href") + " and the status code was "+responseCode);
        }

        softAssert.assertAll();
    }
}
