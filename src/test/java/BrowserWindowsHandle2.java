import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class BrowserWindowsHandle2 {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        Actions actions = new Actions(driver);

        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();

        WebElement reg_element = driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a"));

        actions.keyDown(Keys.CONTROL).click(reg_element).keyUp(Keys.CONTROL).build().perform();

        List<String> tabIDs = new ArrayList(driver.getWindowHandles());

        driver.switchTo().window(tabIDs.get(1));

        System.out.println(driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div/div[1]/h1")).getText());

        driver.switchTo().window(tabIDs.get(0));

        System.out.println(driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div/div/div[2]/div[1]/h2")).getText());

        driver.quit();

    }
}
