
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.FormPage;
import pages.MenuPage;


public class FormTest extends BaseTest {

   MenuPage menuPage;
   FormPage formPage;

   @BeforeMethod
   public void setup(){
       menuPage=new MenuPage(driver);
       formPage=new FormPage(driver);
       menuPage.openDemoSitesMenu()
               .openForm();
   }

    @Test
    public void formTest() {
        formPage.inputFirstName("Wiola")
                .inputLastName("Rudzka")
                .selectSex()
                .selectYearsOFExperience()
                .inputDate("2018-10-17")
                .selectProfession()
                .uploadPhoto()
                .selectContinent("Africa")
                .selectSeleniumCommands("Browser Commands",2)
                .clickButton();
    }
}
