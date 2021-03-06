package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.Arrays;


public class MenuPage extends BasePage {

    public MenuPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        waitUntilElementsVisible();
    }

    @FindBy(css = ".main-nav .menu-item-home")
    private WebElement menuHome;

    @FindBy(xpath = "//span//span//span[contains(text(),'DEMO SITES')]")
    private WebElement menuDemoSites;

    @FindBy(xpath = "//span//span//span[contains(text(),'Automation Practice Form')]")
    private WebElement form;

    @FindBy(xpath = "//span//span//span[contains(text(),'Automation Practice Table')]")
    private WebElement table;

    @FindBy(xpath = "//span//span//span[contains(text(),'Handling Alerts using Selenium WebDriver')]")
    private WebElement alerts;

    @FindBy(xpath = "//span//span//span[contains(text(),'Automation Practice Switch Windows')]")
    private WebElement switchWindows;

    @FindBy(xpath = "//span//span//span[contains(text(),'IFrame practice page')]")
    private WebElement iFarme;

    public void waitUntilElementsVisible(){
        waitForElements(Arrays.asList(menuHome,menuDemoSites));
    }
    public void openHomeFromMenu() {
        menuHome.click();
    }
    public MenuPage openDemoSitesMenu() {
        menuDemoSites.click();
        return this;
    }
    public void openForm() {
        waitForClickElement(form);
        form.click();
    }
    public void openTable() {
        waitForClickElement(table);
        table.click();
    }
    public void openAlerts() {
        waitForClickElement(alerts);
        alerts.click();
    }
    public void openSwitchWindows() {
        waitForClickElement(switchWindows);
        switchWindows.click();
    }
    public void openiFrame() {
        waitForClickElement(iFarme);
        iFarme.click();
    }

}
