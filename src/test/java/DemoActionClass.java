import Util.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DemoActionClass {

    WebDriver driver = new ChromeDriver();
    Actions action = new Actions(driver);

    @Test
    public void hoverTest() throws InterruptedException {
        driver.get("https://qaplayground.dev/#apps");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("/html/body/main/div[3]/a[17]/div/div")).click();
        action.moveToElement(driver.findElement(By.xpath("/html/body/main/div/div/div[1]/a/img"))).build().perform();
        Thread.sleep(5000);
        driver.quit();
    }

    @Test
    public void rightClick() throws InterruptedException {
        driver.get("https://qaplayground.dev/#apps");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("/html/body/main/div[3]/a[16]/div/div/img")).click();
        action.moveToElement(driver.findElement(By.xpath("//*[@id=\"msg\"]"))).contextClick().build().perform();
        Thread.sleep(5000);
        driver.quit();
    }

    @Test
    public void holdOnKeyboardKey() throws InterruptedException {
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
        //After clicking a specific button, don't forget to release it with keyUP
        action.moveToElement(driver.findElement(By.xpath("//*[@id=\"APjFqb\"]"))).click().keyDown(Keys.SHIFT).sendKeys("hello world").keyUp(Keys.SHIFT).build().perform();
        //You can use or remove click() function in case of typing
        action.moveToElement(driver.findElement(By.xpath("//*[@id=\"APjFqb\"]"))).sendKeys(" hello world").build().perform();
        Thread.sleep(5000);
        driver.quit();
    }

    @Test
    public void doubleClick() throws InterruptedException {
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
        action.moveToElement(driver.findElement(By.xpath("//*[@id=\"APjFqb\"]"))).click().keyDown(Keys.SHIFT).sendKeys("hello world").doubleClick().build().perform();
        Thread.sleep(5000);
        driver.quit();
    }

    @Test
    public void dragAndDrop() throws InterruptedException {
        driver.get("https://qaplayground.dev/#apps");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("/html/body/main/div[3]/a[5]/div/div")).click();

        WebElement elementIWantToDrag = driver.findElement(By.xpath("//*[@id=\"draggable-list\"]/li[1]/div"));
        WebElement webElementPathWhereIWantMyElementToBeDragged = driver.findElement(By.xpath("//*[@id=\"draggable-list\"]/li[3]/div"));
        Thread.sleep(5000);
        action.dragAndDrop(elementIWantToDrag, webElementPathWhereIWantMyElementToBeDragged).build().perform();
        Thread.sleep(5000);
        driver.quit();
        /*
        You can also drag a specific element to a specific page if you know X and Y coordinate of the target place where the element should be dragged

        actions.dragAndDropBy(WebElement source, int xOffset, int yOffset)

       --Finding and offset of a specific element

        WebElement element = driver.findElement(By.xpath("xpath_of_your_element"));
        Point elementLocation = element.getLocation();
        int xCoordinate = elementLocation.getX();
        int yCoordinate = elementLocation.getY();
        */
    }

    @Test
    public void pressTwoKeysTogether() throws InterruptedException {
        driver.get("https://en.key-test.ru/");
        driver.manage().window().maximize();
        Thread.sleep(5000);
        action.keyDown(Keys.SHIFT).keyDown(Keys.CONTROL).build().perform();
        Thread.sleep(5000);
        action.keyUp(Keys.CONTROL).keyUp(Keys.SHIFT).build().perform();
        driver.quit();
    }

    @Test
    public void scrollByOffset() throws InterruptedException {
        driver.get("https://scrollmagic.io/examples/advanced/infinite_scrolling.html");
        driver.manage().window().maximize();
        Thread.sleep(5000);
        Utils.scrollByOffset(driver, 0, 150);
        Thread.sleep(5000);
        driver.quit();
    }

}
