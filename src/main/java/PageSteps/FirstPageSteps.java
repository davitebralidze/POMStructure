package PageSteps;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import PageElements.FirstPageElements;

import java.awt.*;
import java.time.Duration;

import static Util.Utils.typeText;

public class FirstPageSteps extends FirstPageElements {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public FirstPageSteps(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Step("Give data to a search bar")
    public void inputSearchData(String input) {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(getSearchBarXPath()));
            driver.findElement(getSearchBarXPath()).sendKeys(input);
        } catch (Exception e) {
            Allure.addAttachment("Error message", "Search bar could not be located");
            throw e;
        }
    }

    @Step("Click on the input bar and fill the information")
    public void inputSearchDataWithRobot(String text) {
        wait.until(ExpectedConditions.presenceOfElementLocated(getSearchBarXPath()));
        driver.findElement(getSearchBarXPath()).click();
        try {
            typeText(new Robot(), text);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

}
