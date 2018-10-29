package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;

public class IFramePage extends BasePage {

    public IFramePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "iframe[name='iframe1']")
    private WebElement ifamePracticeForm;
    @FindBy(css = "iframe[name='iframe2']")
    private WebElement ifameKnowledgeBase;
    @FindBy(css = "button[id='submit']")
    private WebElement submitButton;
    @FindBy(css = ".visible-xs")
    private WebElement readMoreButton;
    @FindBy(css = ".main-nav .menu-item-home")
    private WebElement homeButton;



    public IFramePage switchToFramePracticeForm(){
        waitForElements(Arrays.asList(ifamePracticeForm));
        driver.switchTo().frame(ifamePracticeForm);
        return this;
    }
    public IFramePage switchToFrameKnowledgeBase(){
        driver.switchTo().frame(ifameKnowledgeBase);
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
    public IFramePage switchToParentFrame(){
        driver.switchTo().parentFrame();
        return this;
    }
    public void clickToHomeButton(){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(homeButton));
        homeButton.click();
    }
}
