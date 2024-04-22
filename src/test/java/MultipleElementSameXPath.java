import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleElementSameXPath {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://techwave.ge/");
        Thread.sleep(5000);
        driver.findElement(By.xpath("(//input[@name='searchText'])[1]")).sendKeys("first one");
        driver.findElement(By.xpath("(//input[@name='searchText'])[2]")).sendKeys("second one");
    }
}
