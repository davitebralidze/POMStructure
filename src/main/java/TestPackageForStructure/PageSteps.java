package TestPackageForStructure;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;

public class PageSteps extends PageElements {

    public PageSteps(WebDriver driver) {
        super(driver);
    }

    @Step
    public void inputData(String text) {
        searchBox.sendKeys(text);
    }



}
