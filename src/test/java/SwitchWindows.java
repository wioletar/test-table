import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.ArrayList;
import static org.testng.AssertJUnit.assertEquals;

public class SwitchWindows extends BaseTest {



    @Test
    public void newBrowserWindowTest() throws InterruptedException {
        driver.get("http://toolsqa.com/automation-practice-switch-windows/");
        WebElement button = driver.findElement(By.cssSelector("button[onClick='newBrwTab()']"));
        button.click();
        ArrayList<String> windowHandles = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(windowHandles.get(1));
        driver.manage().window().maximize();
        WebElement menu=driver.findElement(By.cssSelector(".main-nav .menu-item-home"));
        menu.click();
        driver.close();
        driver.switchTo().window(windowHandles.get(0));
        WebElement element = driver.findElement(By.cssSelector(".main-nav .menu-item-home"));
        element.click();
        Thread.sleep(5000);
    }

    @Test
    public void newMessageWindowTest() {
        driver.get("http://toolsqa.com/automation-practice-switch-windows/");
        WebElement button = driver.findElement(By.cssSelector("button[onClick='newMsgWin()']"));
        button.click();
        ArrayList<String> windowHandles = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(windowHandles.get(1));
        String text = driver.findElement(By.tagName("body")).getText();
        System.out.println(text);
        assertEquals(text, "Knowledge increases by sharing but not by saving. Please share this website with your friends and in your organization.");
        driver.close();
        driver.switchTo().window(windowHandles.get(0));
        WebElement element = driver.findElement(By.cssSelector(".main-nav .menu-item-home"));
        element.click();
    }

    @Test
    public void newBrowserTabTest() throws InterruptedException {
        driver.get("http://toolsqa.com/automation-practice-switch-windows/");
        WebElement button = driver.findElement(By.cssSelector("button[onClick='newBrwTab()']"));
        button.click();
        ArrayList<String> windowHandles = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(windowHandles.get(1));
        WebElement menu=driver.findElement(By.cssSelector(".main-nav .menu-item-home"));
        menu.click();
        driver.close();
        driver.switchTo().window(windowHandles.get(0));
        WebElement element = driver.findElement(By.cssSelector(".main-nav .menu-item-home"));
        element.click();
        Thread.sleep(5000);

    }

    @Test
    public void alertBoxTest() throws InterruptedException {
        driver.get("http://toolsqa.com/automation-practice-switch-windows/");
        WebElement button = driver.findElement(By.cssSelector("button[onclick='newAlert()']"));
        button.click();
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(),"Knowledge increases by sharing but not by saving. Please share this website with your friends and in your organization.");
        Thread.sleep(5000);
        alert.accept();
        driver.close();
    }
    @Test
    public void iFrameTest() throws InterruptedException {
        driver.get("http://toolsqa.com/");
        WebElement menuElement = driver.findElement(By.cssSelector(".main-nav .menu-item-17611"));
        menuElement.click();
        WebElement subMenuElement=driver.findElement(By.cssSelector(".sub-nav .menu-item-23300"));
        subMenuElement.click();

        WebElement frame1 = driver.findElement(By.cssSelector("iframe[name='iframe1']"));
        driver.switchTo().frame(frame1);
        WebElement button=driver.findElement(By.cssSelector("button[id='submit']"));
        button.click();

        driver.switchTo().parentFrame();

        WebElement frame2=driver.findElement(By.cssSelector("iframe[name='iframe2']"));
        driver.switchTo().frame(frame2);
        WebElement buttonReadMore=driver.findElement(By.cssSelector(".visible-xs"));
        buttonReadMore.click();

        driver.switchTo().parentFrame();

        WebElement homeElement=driver.findElement(By.cssSelector(".main-nav .menu-item-home"));
        homeElement.click();

        Thread.sleep(2000);


    }

}
