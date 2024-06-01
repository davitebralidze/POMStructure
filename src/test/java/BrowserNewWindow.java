import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserNewWindow {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.facebook.com/");
        Thread.sleep(5000);

        driver.switchTo().newWindow(WindowType.TAB);

        driver.get("https://www.youtube.com/");
        Thread.sleep(5000);

        driver.quit();
    }
}
