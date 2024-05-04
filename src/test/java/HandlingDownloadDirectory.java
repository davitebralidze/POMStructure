import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class HandlingDownloadDirectory {
    public static void main(String[] args) throws InterruptedException {

        //Create downloads file in case needed
        if(!((new File(System.getProperty("user.dir") + File.separator + "Downloads")).exists() && (new File(System.getProperty("user.dir")).isDirectory()))) {
            (new File(System.getProperty("user.dir") + File.separator + "Downloads")).mkdir();
        }

        ChromeOptions options = new ChromeOptions();
        Map<String , Object> prefs = new HashMap<String , Object>();
        prefs.put("download.default_directory" , "C:\\Users\\User\\IdeaProjects\\POMStructure\\Downloads");
        options.setExperimentalOption("prefs", prefs);

        WebDriver driver = new ChromeDriver(options);



        driver.get("https://qaplayground.dev/apps/download/");


        WebElement downloadButton = driver.findElement(By.xpath("//*[@id=\"file\"]"));


        String downloadUrl = downloadButton.getAttribute("href");
        String[] parts = downloadUrl.split("/");
        String fileName = parts[parts.length - 1];
        String filePath = System.getProperty("user.dir") + File.separator + "Downloads"+File.separator + fileName;


        File file = new File(filePath);
        downloadButton.click();

        while(!file.exists()) {try {Thread.sleep(1000);} catch (Exception ignored) {}}

        driver.quit();

    }
}
