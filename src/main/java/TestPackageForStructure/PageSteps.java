package TestPackageForStructure;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class PageSteps extends PageElements {

    public PageSteps(WebDriver driver) {
        super(driver);
    }

    @Step
    public void inputData(String text) {
        searchBox.sendKeys(text);
    }

}
