import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

public class FormTest extends BaseTest {


    @Test
    public void inputFirstNameTest() {

        driver.get("http://toolsqa.com/automation-practice-form/");
        WebElement firstNameInput = driver.findElement(By.cssSelector("input[name='firstname']"));
        firstNameInput.sendKeys("Wiola");

    }

    @Test
    public void inputLastNameTest() {

        driver.get("http://toolsqa.com/automation-practice-form/");
        WebElement lastNameInput = driver.findElement(By.cssSelector("input[name='lastname']"));
        lastNameInput.sendKeys("Rudzka");
    }

    // jak sprawdzić, że w drugi rodzaj płci nie możemy kliknąć?
    @Test
    public void selectSexTest() {

        driver.get("http://toolsqa.com/automation-practice-form/");
        WebElement sexSelect = driver.findElement(By.cssSelector("input[value='Female']"));
        sexSelect.click();
        WebElement sexSelect2 = driver.findElement(By.cssSelector("input[value='Male']"));
        sexSelect2.click();
        Assert.assertEquals(sexSelect.isSelected(), true);
        Assert.assertEquals(sexSelect.getAttribute("name"), "sex"); // dla type nie działą
    }


    @Test
    public void selectYearsOFExperienceTest() {
        Random rand = new Random();
        int  n = rand.nextInt(6) + 1;
        driver.get("http://toolsqa.com/automation-practice-form/");
        List<WebElement> radiobuttons=driver.findElements(By.cssSelector("input[name='exp']"));
        radiobuttons.get(n).click();
    }

    @Test
    public void inputDateTest() {

        driver.get("http://toolsqa.com/automation-practice-form/");
        WebElement dateInput = driver.findElement(By.cssSelector("input[id='datepicker']"));
        dateInput.sendKeys("2018-10-17");
    }
    // czy tu sprawdzamy wszystkie możliwości kliknięcia w checkbox?

    @Test
    public void selectProfessionTest() {

        driver.get("http://toolsqa.com/automation-practice-form/");
        WebElement automationTesterSelect = driver.findElement(By.cssSelector("input[value='Automation Tester']"));
        WebElement manualTesterSelect = driver.findElement(By.cssSelector("input[value='Manual Tester']"));
        automationTesterSelect.click();
        manualTesterSelect.click();

    }

    @Test
    public void uploadFileTest() {

        driver.get("http://toolsqa.com/automation-practice-form/");
        WebElement uploadElement = driver.findElement(By.cssSelector("input[id='photo']"));
        uploadElement.sendKeys("C:\\Users\\wrudzka\\IdeaProjects\\test-table\\src\\main\\resources\\kwiaty.jpg");
    }

    @Test
    public void selectContinentTest() {

        driver.get("http://toolsqa.com/automation-practice-form/");
        Select country= new Select(driver.findElement(By.name("continents")));
        country.selectByVisibleText("Africa");

    }
    @Test
    public void selectSeleniumCommandsTest() {

        driver.get("http://toolsqa.com/automation-practice-form/");
        Select selenium_commands= new Select(driver.findElement(By.id("selenium_commands")));
        selenium_commands.selectByVisibleText("Browser Commands");
        selenium_commands.selectByIndex(2);

    }
    @Test
    public void clickButtonTest() {

        driver.get("http://toolsqa.com/automation-practice-form/");
        WebElement button = driver.findElement(By.cssSelector("button[name='submit']"));
        button.click();
    }

}
