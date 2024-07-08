import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingAuthenticatedPopUpWindows {
    public static void main(String[] args) throws InterruptedException {

        String username = "admin",
                password = "admin";

        String domain = "the-internet.herokuapp.com";
        String URI = "/basic_auth";
        String protocol = "http://";

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //To give authenticated popup credentials there is a special syntax :
        // http://username:password@domain+URI
        //In our case

        driver.get(protocol+username+":"+password+"@"+domain+URI);

        Thread.sleep(5000);
        driver.quit();

    }
}
