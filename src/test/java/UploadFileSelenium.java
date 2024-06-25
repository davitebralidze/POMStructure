import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

public class UploadFileSelenium {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.guru99.com/test/upload/");

        String filePath = System.getProperty("user.dir") + "\\TestFiles\\UploadTest.png";

        driver.findElement(By.xpath("//*[@id=\"uploadfile_0\"]")).sendKeys(filePath);
        driver.findElement(By.xpath("//*[@id=\"terms\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"submitbutton\"]")).click();
        Thread.sleep(5000);
        driver.quit();
    }
}
