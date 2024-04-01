import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingBrowserCookies {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        //Delete all cookies
        driver.manage().deleteAllCookies();
        //Delete specific cookie
        driver.manage().deleteCookieNamed("TestCookie");
    }
}
