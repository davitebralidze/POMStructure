import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RatingSlider {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        Actions action = new Actions(driver);

        driver.get("https://qaplayground.dev/apps/range-slider/");
        driver.manage().window().maximize();
        double percent = 1;
        WebElement slider = driver.findElement(By.xpath("/html/body/div/div[2]/div[1]"));
        int sliderTotalSize = driver.findElement(By.xpath("/html/body/div/div[2]/input")).getSize().getWidth();
        System.out.println(sliderTotalSize);
        System.out.println(percent);
        double xOffset = sliderTotalSize*percent;
        System.out.println(xOffset);



        action.dragAndDropBy(slider, (int)xOffset, 0).build().perform();




    }

}
