import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class BrowserWindowsHandle {

    WebDriver driver = new ChromeDriver();

    @Test
    public void handleNewTab() throws InterruptedException {
        driver.get("https://qaplayground.dev/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("/html/body/main/div[3]/a[6]/div/p")).click();
        driver.findElement(By.xpath("//*[@id=\"open\"]")).click();

        //At first we need to track how many windows are opened
        Set<String> windows = driver.getWindowHandles();
        //Create an iterator for windows (to pull IDs)
        Iterator<String> it = windows.iterator();
        //it.next() will help you to get the next element of the Set (by default it is outside of the boundaries)
        //every time you call it.next() , index will increase
        String firstWindow = it.next();
        String secondWindow = it.next();
        //Switch to second window (change the driver scope to the second tab)
        driver.switchTo().window(secondWindow);
        //This will print text from the second tab
        System.out.println(driver.findElement(By.xpath("//*[@id=\"wrapper\"]/h1")).getText());
        //To return to the main page, at first you must close current window
        driver.close();
        //We have to return to the tab we want to continue working with
        driver.switchTo().window(firstWindow);

        driver.quit();

    }

}
