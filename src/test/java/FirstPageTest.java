import data.FirstPageData;
import org.testng.Assert;
import org.testng.annotations.Test;
import util.BaseUtility;


public class FirstPageTest extends BaseUtility implements FirstPageData {

    @Test
    public void testing() {
        firstPageSteps.inputSearchData("Hello23425425");
        Assert.assertEquals(expectedURL, driver.getCurrentUrl());
    }

    @Test
    public void testingRobotInsertingInformation() {
        firstPageSteps.inputSearchDataWithRobot("This text was inserted with robot!");
    }

}