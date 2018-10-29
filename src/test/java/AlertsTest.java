import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AlertsPage;
import pages.MenuPage;

public class AlertsTest extends BaseTest {


    MenuPage menuPage;
    AlertsPage alertsPage;


    @BeforeMethod
    public void setup(){
        menuPage=new MenuPage(driver);
        alertsPage = new AlertsPage(driver);

        menuPage.openDemoSitesMenu()
                .openAlerts();
    }

    @Test
    public void simpleAlertTest() {
        alertsPage.clickSimpleAlertButton()
                .switchToAlert()
                .acceptAlert();
    }

    @Test
    public void confirmAlertTest() {
        alertsPage.clickConfirmAlertButton()
                .switchToAlert()
                .acceptAlert()
                .getConfirmAlertMessage()
                .clickConfirmAlertButton()
                .switchToAlert()
                .dismissAlert()
                .getConfirmAlertMessage();
    }

    @Test
    public void promptAlertTest() {
       alertsPage.clickPromptAlertButton()
               .switchToAlert()
               .sendMessageToAlert("Yes")
               .acceptAlert();
    }
}
