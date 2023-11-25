package pageElements;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@Getter
public class FirstPageElements {


    private final By searchBarPath = By.xpath("//*[@id=\"APjFqb\"]");
    private final By searchButtonPath = By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[4]/center/input[1]");


}
