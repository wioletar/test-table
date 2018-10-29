package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class FormPage extends BasePage {

    public FormPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "input[name='firstname']")
    private WebElement firstNameInput;

    @FindBy(css = "input[name='lastname']")
    private WebElement lastNameInput;

    @FindBy(css = "button[name='submit']")
    private WebElement button;

    @FindBy(css = "input[id='photo']")
    private WebElement uploadElement;

    @FindBy(css = "input[id='datepicker']")
    private WebElement dateInput;

    @FindBy(css = "input[name='exp']")
    private List<WebElement> radiobuttonsYearsOfExperience;

    @FindBy(css = "input[name='sex']")
    private List<WebElement> radiobuttonsSex;

    @FindBy(css = "input[name='profession']")
    private List<WebElement> checkboxProfession;

    @FindBy(name = "continents")
    private WebElement continents;

    @FindBy(id = "selenium_commands")
    private WebElement seleniumCommands;


    public FormPage inputFirstName(String name){
        waitForElements(Arrays.asList(firstNameInput));
        firstNameInput.sendKeys(name);
        return this;
    }

    public FormPage inputLastName(String name){
        lastNameInput.sendKeys(name);
        return this;
    }

    public FormPage inputDate(String date){
        dateInput.sendKeys(date);
        return this;
    }

    public FormPage uploadPhoto(){
        File file = new File(getClass().getClassLoader().getResource("kwiaty.jpg").getFile());
        uploadElement.sendKeys(file.getAbsolutePath());

        return this;
    }

    public FormPage selectSex(){
        Random rand = new Random();
        int  n = rand.nextInt(1) + 1;
        radiobuttonsSex.get(n).click();
        return this;
    }

    public FormPage selectYearsOFExperience(){
        Random rand = new Random();
        int  n = rand.nextInt(6) + 1;
        radiobuttonsYearsOfExperience.get(n).click();
        return this;
    }

    public FormPage selectProfession(){
        Random rand = new Random();
        int  n = rand.nextInt(1) + 1;
        checkboxProfession.get(n).click();
        return this;
    }

    public FormPage selectContinent(String continentName){
        Select country= new Select(continents);
        country.selectByVisibleText(continentName);
        return this;
    }

    public FormPage selectSeleniumCommands(String commandName, int index){
        Select selenium_commands= new Select(seleniumCommands);
        selenium_commands.selectByVisibleText(commandName);
        selenium_commands.selectByIndex(index);
        return this;
    }

    public void clickButton(){
        button.click();
    }
}
