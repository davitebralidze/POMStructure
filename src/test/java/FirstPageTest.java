import data.FirstPageData;
import org.testng.Assert;
import pageSteps.FirstPageSteps;
import util.BaseUtility;
import org.testng.annotations.Test;

public class FirstPageTest extends BaseUtility {

    @Test(description = "Testing process")
    public void testingTest() {
        firstPageSteps.getSearchBar().sendKeys("Hello");
        takeScreenshot();
    }
}
