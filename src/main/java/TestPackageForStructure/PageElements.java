package TestPackageForStructure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;

public class PageElements {

    public PageElements (WebDriver driver) {
        this.driver = driver;

    }
    WebDriver driver;
    WebElement searchBox = driver.findElement(By.xpath("//*[@id=\"APjFqb\"]"));;

}
