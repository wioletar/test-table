import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.IFramePage;
import pages.MenuPage;

public class IFrameTest extends BaseTest {

    MenuPage menuPage;
    IFramePage iFramePage;

    @BeforeMethod
    public void setup(){
        menuPage=new MenuPage(driver);
        iFramePage=new IFramePage(driver);
        menuPage.openDemoSitesMenu()
                .openiFrame();
    }
    @Test
    public void iFrameTest() {
        iFramePage.switchToFramePracticeForm()
                .clickToSubmitButton()
                .switchToParentFrame()
                .switchToFrameKnowledgeBase()
                .clickToReadMoreButton()
                .switchToParentFrame()
                .clickToHomeButton();
    }
}
