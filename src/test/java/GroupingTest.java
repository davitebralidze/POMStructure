import org.testng.annotations.Test;

public class GroupingTest {

    @Test(groups = "First Test")
    public void firstTest() {
        System.out.println("First Test");
    }

    @Test(groups = "Second Test")
    public void secondTest() {
        System.out.println("Second Test");
    }

    @Test(groups = "Third Test")
    public void thirdTest() {
        System.out.println("Third Test");
    }

}
