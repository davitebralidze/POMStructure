package pageElements;

import lombok.Getter;
import org.openqa.selenium.By;

@Getter /*This lombok annotation gives the getter method implicitly*/
public class FirstPageElements {

    private final By searchBarXPath = By.xpath("//*[@id=\"APjFqb\"]");

    //In case you do not use the lombok annotation you can create getter method by yourself or with help of the IntelIJ
     /*
     public By getSearchBarXPath() {
        return searchBarXPath
     }
     */

}
