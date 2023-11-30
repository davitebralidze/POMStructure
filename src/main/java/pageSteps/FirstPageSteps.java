package pageSteps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageElements.FirstPageElements;

import java.time.*;

public class FirstPageSteps extends FirstPageElements {

    private final WebDriver driver;
    private final WebDriverWait wait;
    Duration EXPLICIT_WAIT = Duration.ofSeconds(60);

    public FirstPageSteps(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, EXPLICIT_WAIT);
    }

    @Step("Give data to a search bar")
    public void inputSearchData(String input) {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(getSearchBarXPath())));
        driver.findElement(getSearchBarXPath()).sendKeys(input);
    }
}
