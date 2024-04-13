import org.testng.annotations.Test;

public class DataProviderExample {


    @Test(dataProvider = "loginData", dataProviderClass = DataProvider.DataProviderClass.class)
    public void testLogin(String username, String password) {
        System.out.println("Logging in with username: " + username + " and password: " + password);
    }
}
