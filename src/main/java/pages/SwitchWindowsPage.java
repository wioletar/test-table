package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.ArrayList;
import java.util.Arrays;

import static org.testng.AssertJUnit.assertEquals;

public class SwitchWindowsPage extends BasePage {

    public SwitchWindowsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        waitUntilElementsVisible();
    }

    @FindBy(css = "button[onClick='newBrwWin()']")
    private WebElement newBrowserWindowButton;

    @FindBy(css = ".main-nav .menu-item-home")
    private WebElement homeMenuButton;

    @FindBy(css = "button[onClick='newMsgWin()']")
    private WebElement newMessageWindowButton;

    @FindBy(css = "button[onClick='newBrwTab()']")
    private WebElement newBrowserTabButton;

    @FindBy(css = "body")
    private WebElement newMessageWindowText;

    public void waitUntilElementsVisible(){
        waitForElements(Arrays.asList(newBrowserWindowButton,homeMenuButton,newMessageWindowButton,newBrowserTabButton,newMessageWindowText));
    }

    public SwitchWindowsPage clickNewBrowserWindowButton(){
        newBrowserWindowButton.click();
        return this;
    }

    public void clickHomeMenuButton(){
        homeMenuButton.click();
    }

    public SwitchWindowsPage clickNewBrowserTabButton(){
        newBrowserTabButton.click();
        return this;
    }

    public SwitchWindowsPage clickNewMessageWindowButton(){
        newMessageWindowButton.click();
        return this;
    }

    public SwitchWindowsPage switchToNewWindow(int windowNumber){
        ArrayList<String> windowHandles=new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(windowHandles.get(windowNumber));
        driver.manage().window().maximize();
        return this;
    }

    public SwitchWindowsPage getNewMessageWindowText(){
        String text=newMessageWindowText.getText();
        System.out.println(text);
        assertEquals(text, "Knowledge increases by sharing but not by saving. Please share this website with your friends and in your organization.");
        return this;
    }

    public SwitchWindowsPage closeWindow(){
        driver.close();
        return this;
    }


}
