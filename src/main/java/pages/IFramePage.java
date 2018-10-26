package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;

public class IFramePage extends BasePage {

    public IFramePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        waitUntilElementsVisible();
    }

    @FindBy(css = "iframe[name='iframe1']")
    private WebElement ifame1;
    @FindBy(css = "iframe[name='iframe2']")
    private WebElement ifame2;
    @FindBy(css = "button[id='submit']")
    private WebElement submitButton;
    @FindBy(css = ".visible-xs")
    private WebElement readMoreButton;
    @FindBy(css = ".main-nav .menu-item-home")
    private WebElement homeButton;

    public void waitUntilElementsVisible(){
        waitForElements(Arrays.asList(ifame1,ifame2,submitButton,readMoreButton,homeButton));
    }

    public IFramePage switchToFarme1(){
        driver.switchTo().frame(ifame1);
        return this;
    }
    public IFramePage switchToFarme2(){
        driver.switchTo().frame(ifame2);
        return this;
    }
    public IFramePage clickToSubmitButton(){
        submitButton.click();
        return this;
    }
    public IFramePage clickToReadMoreButton(){
        readMoreButton.click();
        return this;
    }
    public IFramePage switchToParentFarme(){
        driver.switchTo().parentFrame();
        return this;
    }
    public void clickToHomeButton(){
        homeButton.click();
    }
}
