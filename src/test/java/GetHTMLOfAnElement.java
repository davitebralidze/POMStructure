import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GetHTMLOfAnElement {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://techwave.ge/");
        try {
            Thread.sleep(5000);
        } catch (Exception ignored){}
        WebElement element = driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/header/div/div/nav/div[3]/div/div[1]/a[2]"));
        String html = element.getAttribute("outerHTML");

        System.out.println(html);

        driver.quit();

    }
}
