import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SliderTest2 {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        Actions actions = new Actions(driver);
        driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
        driver.manage().window().maximize();

        WebElement min_slider = driver.findElement(By.xpath("//*[@id=\"slider-range\"]/span[1]"));

        Point point_low = min_slider.getLocation();

        System.out.println(point_low); // (59, 250)

        actions.dragAndDropBy(min_slider, 100, 0).build().perform();

        System.out.println(min_slider.getLocation());

        driver.quit();

    }
}
