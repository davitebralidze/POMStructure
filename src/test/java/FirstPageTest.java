import Util.BaseUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstPageTest extends BaseUtility {

    @Test(groups = "smoke")
    public void testing() {
        System.out.println("FirstPageTest first test invoked");
        firstPageSteps.inputSearchData("Hello23425425");
        Assert.assertEquals(propertyLoader.returnConfigValue("expectedURL"), driver.getCurrentUrl(), "The URL was not as expected");


    }

    @Test
    public void testingRobotInsertingInformation() {
        System.out.println("FirstPageTest second test invoked");
        firstPageSteps.inputSearchDataWithRobot("This text was inserted with robot!");
    }

}
