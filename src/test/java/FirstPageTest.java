import data.FirstPageData;
import org.testng.Assert;
import util.BaseUtility;
import org.testng.annotations.Test;
import util.Utils;

import java.awt.*;

import static util.Utils.typeText;

public class FirstPageTest extends BaseUtility implements FirstPageData {

    @Test
    public void testing() {
        firstPageSteps.inputSearchData("Hello23425425");
        Assert.assertEquals(expectedURL, driver.getCurrentUrl());
    }

    @Test
    public void testingRobotInsertingInformation() throws AWTException {
        firstPageSteps.inputSearchDataWithRobot("This text was inserted with robot");
    }

}