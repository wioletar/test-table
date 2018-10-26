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
    }

    @Test
    public void simpleAlertTest() throws InterruptedException {

        menuPage.openDemoSitesMenu().openAlerts();
        alertsPage.clickSimpleAlertButton().switchToAlert().acceptAlert();
    }

    @Test
    public void confirmAlertTest() {

        menuPage.openDemoSitesMenu().openAlerts();
        alertsPage.clickConfirmAlertButton().switchToAlert().acceptAlert().getConfirmAlertMessage()
        .clickConfirmAlertButton().switchToAlert().dismissAlert().getConfirmAlertMessage();
//        alertsPage.switchToAlert();
//        alertsPage.acceptAlert();
//        alertsPage.getConfirmAlertMessage();
//        alertsPage.clickConfirmAlertButton();
//        alertsPage.switchToAlert();
//        alertsPage.dismissAlert();
//        alertsPage.getConfirmAlertMessage();

    }

    @Test
    public void promptAlertTest() throws InterruptedException {

        menuPage.openDemoSitesMenu().openAlerts();
        alertsPage.clickPromptAlertButton();
        alertsPage.switchToAlert();
        alertsPage.sendMessageToAlert("Yes");
        alertsPage.acceptAlert();

    }


}
