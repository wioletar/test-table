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
        menuPage.openDemoSitesMenu()
                .openSwitchWindows();
    }

    @Test
    public void newBrowserWindowTest() {
        switchWindowsPage.clickNewBrowserWindowButton()
                        .switchToNewWindow(1);
        menuPage.openHomeFromMenu();
        switchWindowsPage.closeWindow()
                        .switchToNewWindow(0);
        menuPage.openHomeFromMenu();
    }

    @Test
    public void newMessageWindowTest() {
        switchWindowsPage.clickNewMessageWindowButton()
                        .switchToNewWindow(1)
                        .getNewMessageWindowText()
                        .closeWindow()
                        .switchToNewWindow(0);
        menuPage.openHomeFromMenu();
    }

    @Test
    public void newBrowserTabTest() {
        switchWindowsPage.clickNewBrowserTabButton()
                        .switchToNewWindow(1);
        menuPage.openHomeFromMenu();
        switchWindowsPage.closeWindow()
                        .switchToNewWindow(0);
        menuPage.openHomeFromMenu();
    }
}
