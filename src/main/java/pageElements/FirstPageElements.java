package pageElements;

import lombok.Getter;
import org.openqa.selenium.By;

@Getter /*lombok annotation that creates getter method, there is also @Setter annotation and @Data (Creates both))*/
public class FirstPageElements {

    private final By searchBarXPath = By.xpath("//*[@id=\"APjFqb\"]");

    //In case you do not use the lombok annotation you can create getter method by yourself or with help of the IntelIJ
     /*
     public By getSearchBarXPath() {
        return searchBarXPath
     }
     */

}
