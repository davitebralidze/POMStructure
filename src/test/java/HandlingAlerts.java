import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingAlerts {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys("David");
        driver.findElement(By.xpath("//*[@id=\"alertbtn\"]")).click();

        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            System.out.println("Alert text is: " + alertText);
            alert.accept();
        } catch (NoAlertPresentException e) {
            System.out.println("No alert is present");
        }
    }
}
