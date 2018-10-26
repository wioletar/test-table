package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class AlertsPage extends BasePage {

    Alert alert;

    public AlertsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        waitUntilElementsVisible();
    }

    @FindBy(css = "button[onclick='pushAlert()']")
    private WebElement simpleAlertButton;

    @FindBy(css = "button[onClick='pushConfirm()']")
    private WebElement confirmAlertButton;

    @FindBy(css = "span[id='ConfirmOption']")
    private WebElement confirmAlertMessage;

    @FindBy(css = "button[onClick='promptConfirm()']")
    private WebElement promptAlertButton;

    public AlertsPage clickSimpleAlertButton(){
        simpleAlertButton.click();
        return this;
    }
    public AlertsPage clickConfirmAlertButton(){
        ((JavascriptExecutor)driver).executeScript("scroll(0,400)");
        confirmAlertButton.click();
        return this;
    }

    public AlertsPage getConfirmAlertMessage(){
        String message;
        message=confirmAlertMessage.getText();
        System.out.println(message);
        return this;
    }

    public AlertsPage clickPromptAlertButton(){
        promptAlertButton.click();
        return this;
    }

    public AlertsPage switchToAlert(){
        alert=driver.switchTo().alert();
        return this;
    }

    public AlertsPage acceptAlert(){
        alert.accept();
        return this;
    }
    public AlertsPage dismissAlert(){
        alert.dismiss();
        return this;
    }

    public AlertsPage sendMessageToAlert(String text){
        alert.sendKeys(text);
        return this;
    }

    public void waitUntilElementsVisible(){
        waitForElements(Arrays.asList(simpleAlertButton,confirmAlertButton,confirmAlertMessage,promptAlertButton));
    }

}
