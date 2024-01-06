package pageSteps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageElements.FirstPageElements;

import java.awt.*;
import java.time.Duration;

import static util.Utils.typeText;

public class FirstPageSteps extends FirstPageElements {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public FirstPageSteps(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(50));
    }

    @Step("Give data to a search bar")
    public void inputSearchData(String input) {
        wait.until(ExpectedConditions.presenceOfElementLocated(getSearchBarXPath()));
        driver.findElement(getSearchBarXPath()).sendKeys(input);
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
