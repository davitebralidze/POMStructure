import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderExample {

    //REMEMBER! DataProvider should always be in the same class where the tests are locetad!

    @DataProvider(name = "loginData")
    public Object[][] provideData() {
        return new Object[][]{
                {"user1", "password1"},
                {"user2", "password2"},
                {"user3", "password3"}};
    }

    @Test(dataProvider = "loginData")
    public void testLogin(String username, String password) {
        System.out.println("Logging in with username: " + username + " and password: " + password);
    }
}
