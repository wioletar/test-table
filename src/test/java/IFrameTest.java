import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AlertsPage;
import pages.IFramePage;
import pages.MenuPage;

public class IFrameTest extends BaseTest {

    MenuPage menuPage;
    IFramePage iFramePage;

    @BeforeMethod
    public void setup(){
        menuPage=new MenuPage(driver);
        iFramePage=new IFramePage(driver);
    }
    @Test
    public void iFrameTest() {

        menuPage.openDemoSitesMenu().openiFrame();
        iFramePage.switchToFarme1().clickToSubmitButton().switchToParentFarme().switchToFarme2()
                .clickToReadMoreButton().switchToParentFarme().clickToHomeButton();
    }
}
