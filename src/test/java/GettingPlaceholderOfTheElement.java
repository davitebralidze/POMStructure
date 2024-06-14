import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class GettingPlaceholderOfTheElement {
    public static void main(String[] args) {

        ChromeOptions options = new ChromeOptions();
        //Making tests go headless
        options.addArguments("--headless=new");

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();

        WebElement element = driver.findElement(By.xpath("//*[@id=\"name\"]"));
        System.out.println(element.getAttribute("placeholder"));

    }
}
