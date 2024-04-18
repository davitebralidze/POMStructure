import PageSteps.FirstPageSteps;
import io.qameta.allure.Allure;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AllureCustomMessage {


    @Test
    public void allureCustomMessage() throws InterruptedException{
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        FirstPageSteps firstPageSteps = new FirstPageSteps(driver);
        driver.get("https://www.google.com/");
        firstPageSteps.inputSearchData("Hello");
    }


}
