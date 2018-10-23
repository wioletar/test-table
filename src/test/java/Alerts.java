import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Alerts extends BaseTest {


    @Test
    public void simpleAlertTest() throws InterruptedException {
        driver.get("http://toolsqa.com/handling-alerts-using-selenium-webdriver/");
        driver.findElement(By.cssSelector("button[onclick='pushAlert()']")).click();
        Alert alert = driver.switchTo().alert();
        Thread.sleep(5000);
        alert.accept();
    }

    @Test
    public void confirmAlertTest() {
        driver.get("http://toolsqa.com/handling-alerts-using-selenium-webdriver/");
        WebElement button = driver.findElement(By.cssSelector("button[onClick='pushConfirm()']"));
        button.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        button.click();
        Alert alert2 = driver.switchTo().alert();
        alert2.dismiss();
    }
    
    @Test
    public void promptAlertTest() {
        WebElement button = driver.findElement(By.cssSelector("button[onClick='promptConfirm()']"));
        button.click();

        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), "Do you like toolsqa?");

        alert.sendKeys("Yes");
        alert.accept();
    }


}
