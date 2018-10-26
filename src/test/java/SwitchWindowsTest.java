import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MenuPage;
import pages.SwitchWindowsPage;


public class SwitchWindowsTest extends BaseTest {

    MenuPage menuPage;
    SwitchWindowsPage switchWindowsPage;

    @BeforeMethod
    public void setup(){
        menuPage=new MenuPage(driver);
        switchWindowsPage = new SwitchWindowsPage(driver);
    }

    @Test
    public void newBrowserWindowTest() {
        menuPage.openDemoSitesMenu().openSwitchWindows();
        switchWindowsPage.clickNewBrowserWindowButton().switchToNewWindow(1);
        menuPage.openHomeFromMenu();
        switchWindowsPage.closeWindow().switchToNewWindow(0).clickHomeMenuButton();
    }

    @Test
    public void newMessageWindowTest() {
        menuPage.openDemoSitesMenu().openSwitchWindows();
        switchWindowsPage.clickNewMessageWindowButton().switchToNewWindow(1).getNewMessageWindowText()
        .closeWindow().switchToNewWindow(0).clickHomeMenuButton();
    }

    @Test
    public void newBrowserTabTest() {
        menuPage.openDemoSitesMenu().openSwitchWindows();
        switchWindowsPage.clickNewBrowserTabButton().switchToNewWindow(1);
        menuPage.openHomeFromMenu();
        switchWindowsPage.closeWindow().switchToNewWindow(0).clickHomeMenuButton();
    }
}
