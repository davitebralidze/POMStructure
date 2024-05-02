import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class HandlingDownloadDirectory {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();

        Map<String , Object> prefs = new HashMap<String , Object>();
        prefs.put("download.default_directory" , "C:\\Users\\User\\IdeaProjects\\POMStructure\\Downloads");
        options.setExperimentalOption("prefs", prefs);

        WebDriver driver = new ChromeDriver(options);

        driver.get("https://qaplayground.dev/apps/download/");
        driver.findElement(By.xpath("//*[@id=\"file\"]")).click();
        driver.quit();

    }
}
