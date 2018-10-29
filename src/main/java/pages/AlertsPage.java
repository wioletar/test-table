package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertsPage extends BasePage {

    Alert alert;

    public AlertsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "button[onclick='pushAlert()']")
    private WebElement simpleAlertButton;

    @FindBy(xpath = "//button[@onclick='pushConfirm()']")
    private WebElement confirmAlertButton;

    @FindBy(css = "span[id='ConfirmOption']")
    private WebElement confirmAlertMessage;

    @FindBy(css = "button[onClick='promptConfirm()']")
    private WebElement promptAlertButton;

    public AlertsPage clickSimpleAlertButton(){
        waitForClickElement(simpleAlertButton);
        simpleAlertButton.click();
        return this;
    }
    public AlertsPage clickConfirmAlertButton(){
        waitForClickElement(confirmAlertButton);
        confirmAlertButton.sendKeys(Keys.ENTER);
        return this;
    }

    public AlertsPage getConfirmAlertMessage(){
        String message;
        message=confirmAlertMessage.getText();
        System.out.println(message);
        return this;
    }

    public AlertsPage clickPromptAlertButton(){
        waitForClickElement(promptAlertButton);
        promptAlertButton.click();
        return this;
    }

    public AlertsPage switchToAlert(){
        waitForAlert();
        alert=driver.switchTo().alert();
        return this;
    }

    public AlertsPage acceptAlert(){
        waitForAlert();
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
}
