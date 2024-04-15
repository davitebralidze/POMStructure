import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class WorkingWithVerification {

    public static void main(String[] args) throws InterruptedException{


        WebDriver driver = new ChromeDriver();

        driver.get("https://qaplayground.dev/apps/verify-account/");
        Thread.sleep(5000);
        List<WebElement> elements = driver.findElements(By.className("code"));
        int[] code = {5, 4, 2, 7, 1, 2};
        int verificationBoxes = elements.size();

        for (int i = 0; i < verificationBoxes; i++) {
            elements.get(i).sendKeys(String.valueOf(code[i]));
        }


    }


}
