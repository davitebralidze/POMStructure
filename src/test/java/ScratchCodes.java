import Util.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScratchCodes {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://thankful-sky-0003e3003.1.azurestaticapps.net/");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[3]/div/div/button[1]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/header/div/div/nav/div[3]/div/div[1]/a[1]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("ride-meant@vcwqys0x.mailosaur.net");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("Dato153109!");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[3]/form/div[6]/button")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/header/div/div/nav/div[2]/div/ul/li[3]/a")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[3]/div[2]/div[1]/a[1]")).click();
        Thread.sleep(5000);

        // Execute JavaScript to remove the element from the DOM
//        ((JavascriptExecutor) driver).executeScript("arguments[0].parentNode.removeChild(arguments[0]);", driver.findElement(By.xpath("//*[@id=\"fb-root\"]")));

        WebElement element = driver.findElement(By.xpath("//*[@id=\"fb-root\"]"));

        Utils.removeElementFromDOM(driver, element);


        Thread.sleep(5000);

        driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[3]/div/div[1]/button")).click();

        Thread.sleep(5000);

        //Scroll to a specific element
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[3]/div[2]/div[2]/div[2]/form/div/div/div[5]")));

        WebElement element1 = driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[3]/div[2]/div[2]/div[2]/form/div/div/div[5]"));
        Utils.scrollToASpecificElement(driver, element1);
        Thread.sleep(5000);

        driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[3]/div[2]/div[2]/div[2]/form/div/div/div[4]/input")).sendKeys("C:\\Users\\User\\OneDrive - Flat Rock Technology\\Desktop\\file formats\\checkme.pdf");

    }
}
