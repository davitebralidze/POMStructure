import util.BaseUtility;
import org.testng.annotations.Test;

public class FirstPageTest extends BaseUtility {

    @Test(description = "Testing process")
    public void testingTest() throws InterruptedException {
        firstPageSteps.inputSearchData("Hello");
        takeScreenshot();
    }
}
