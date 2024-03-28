import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SetBrowserSize {

    @Test
    public void setSpecificWindowSize() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.webfx.com/tools/whats-my-browser-size/");
        driver.manage().window().setSize(new Dimension(1920, 1080));
    }

}
