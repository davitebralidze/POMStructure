import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

public class UploadFileSelenium2 {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://qaplayground.dev/apps/upload/");
        String filePath = System.getProperty("user.dir") + "\\TestFiles\\UploadTest.png";
        driver.findElement(By.xpath("//*[@id=\"file-input\"]")).sendKeys(filePath);
    }
}
