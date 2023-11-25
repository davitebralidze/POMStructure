package pageSteps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageElements.FirstPageElements;

public class FirstPageSteps extends FirstPageElements {


    public FirstPageSteps(WebDriver driver) {
        super(driver);
    }

    @Step("Give data to a search bar")
    public void inputSearchData(String input) {
        getSearchBar().sendKeys(input);
    }
}
