import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import Util.Utils;

public class FirstPageTestWithoutExtend {

    @BeforeSuite
    public void clearAllureReports() {
        Utils.deleteAllureReports();
    }

    @Test
    public void test() {
        System.out.println("FirstPageWithoutExtend!");
    }

}
