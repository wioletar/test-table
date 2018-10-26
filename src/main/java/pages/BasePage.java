package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePage {

    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForElements(List<WebElement> element) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable((WebElement) element));
    }

//    public void waitForElements(List<WebElement> elements){
//        WebDriverWait wait = new WebDriverWait(driver,5);
//       wait.until(ExpectedConditions.visibilityOfAllElements(elements));
//    }
}
