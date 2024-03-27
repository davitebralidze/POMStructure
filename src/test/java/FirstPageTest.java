import Util.PropertyLoader;
import org.testng.Assert;
import org.testng.annotations.Test;
import Util.BaseUtility;


public class FirstPageTest extends BaseUtility {

    @Test(groups ="smoke")
    public void testing() {
        System.out.println("FirstPageTest first test invoked");
        firstPageSteps.inputSearchData("Hello23425425");
        Assert.assertEquals(PropertyLoader.returnConfigValue("expectedURL"), driver.getCurrentUrl());
    }

    @Test
    public void testingRobotInsertingInformation() throws InterruptedException {
        System.out.println("FirstPageTest second test invoked");
        firstPageSteps.inputSearchDataWithRobot("This text was inserted with robot!");
    }

}
