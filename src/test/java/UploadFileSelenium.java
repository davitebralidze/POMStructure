import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UploadFileSelenium {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.guru99.com/test/upload/");

        driver.findElement(By.xpath("//*[@id=\"uploadfile_0\"]")).sendKeys("C:\\Users\\User\\OneDrive - Flat Rock Technology\\Desktop\\file formats\\checkme.pdf");
        driver.findElement(By.xpath("//*[@id=\"terms\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"submitbutton\"]")).click();

    }
}
