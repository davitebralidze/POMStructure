import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import util.Utils;

public class TestingWithoutExtend {

    @BeforeSuite
    public void clearAllureReports() {
        Utils.deleteAllureReports();
    }
    @Test
    public void test() {
        System.out.println("FirstPageWithoutExtend");
    }

}
