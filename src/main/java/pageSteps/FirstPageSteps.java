package pageSteps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageElements.FirstPageElements;

public class FirstPageSteps extends FirstPageElements {

    private final WebDriver driver;

    public FirstPageSteps(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Give data to a search bar")
    public void inputSearchData(String input) {
        driver.findElement(getSearchBarXPath()).sendKeys(input);
    }
}
