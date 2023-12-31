package pageSteps;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageElements.FirstPageElements;

import java.time.Duration;

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

}
