import util.BaseUtility;
import org.testng.annotations.Test;

public class FirstPageTest extends BaseUtility {

    @Test(description = "Testing process")
    public void testingTest() {
        firstPageSteps.inputSearchData("Hello23425425");
    }

    @Test
    public void trustMe() {
        firstPageSteps.inputSearchData("Trust me");
    }


}
