import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.List;

public class SoftAsserts {
    public static void main(String[] args) throws IOException {
        SoftAssert softAssert = new SoftAssert();

        WebDriver driver = new ChromeDriver();
        String baseURL = "https://rahulshettyacademy.com/AutomationPractice";

        driver.get(baseURL);
        List<WebElement> links = driver.findElements(By.cssSelector("li.gf-li a"));

        for (WebElement link : links) {
            String url = link.getAttribute("href");
            System.out.println(url);
            Response response = RestAssured.get(url);
            int responseCode = response.getStatusCode();
            System.out.println(responseCode);
            softAssert.assertTrue(responseCode < 400 ,
                    "The status code was greater than 400 for the link: " +
                            link.getAttribute("href") + " and the status code was "+responseCode+" ///");
        }
        softAssert.assertAll();
    }
}
