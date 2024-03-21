import TestPackageForStructure.PageSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class xxxTestStructure {

    @Test
    public void insertSomeData() {
        WebDriver driver = new ChromeDriver();
        PageSteps pageSteps = new PageSteps(driver);

        driver.get("https://www.google.com/");
        pageSteps.inputData("Hello World");

    }

}
