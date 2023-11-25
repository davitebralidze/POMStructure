package pageElements;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@Getter
public class FirstPageElements {

    WebDriver driver;

    public FirstPageElements(WebDriver driver) {
        this.driver = driver;
    }

    private final WebElement searchBar = driver.findElement(By.xpath("//*[@id=\"APjFqb\"]"));
    private final WebElement searchButton = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[4]/center/input[1]"));


}
