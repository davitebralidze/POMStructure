package pageElements;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@Getter
public class FirstPageElements {

    public WebDriver driver;

    public FirstPageElements(WebDriver driver) {
        this.driver = driver;
    }

    private final By searchBarXPath = By.xpath("//*[@id=\"APjFqb\"]");

    public WebElement searchBar() {
        return driver.findElement(searchBarXPath);
    }

}
