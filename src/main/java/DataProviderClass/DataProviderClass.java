package DataProviderClass;

import org.testng.annotations.DataProvider;
public class DataProviderClass {

    @DataProvider(name = "loginData")
    public Object[][] provideData() {
        return new Object[][]{
                {"user1", "password1"},
                {"user2", "password2"},
                {"user3", "password3"}};
    }

}
