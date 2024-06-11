import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HandlingHeadlessMode {

    public static void main(String[] args) {

        ChromeOptions options = new ChromeOptions();
        //Making tests go headless
        options.addArguments("--headless=new");
        WebDriver driver = new ChromeDriver(options);


    }

}
