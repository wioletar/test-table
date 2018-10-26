import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.FormPage;
import pages.MenuPage;

import java.util.List;
import java.util.Random;

public class FormTest extends BaseTest {

   MenuPage menuPage;
   FormPage formPage;

   @BeforeMethod
   public void setup(){
       menuPage=new MenuPage(driver);
       formPage=new FormPage(driver);
   }

    @Test
    public void formTest() {

        menuPage.openDemoSitesMenu().openForm();
        formPage.inputFirstName("Wiola").inputLastName("Rudzka")
                .selectSex().selectYearsOFExperience().inputDate("2018-10-17").selectProfession()
        .uploadPhoto("C:\\Users\\wrudzka\\IdeaProjects\\test-table\\src\\main\\resources\\kwiaty.jpg")
        .selectContinent("Africa").selectSeleniumCommands("Browser Commands",2).clickButton();

        //  Assert.assertEquals(sexSelect.isSelected(), true);

    }
}
