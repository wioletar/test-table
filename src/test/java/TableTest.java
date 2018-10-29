import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MenuPage;
import pages.TablePage;



public class TableTest extends BaseTest {

    MenuPage menuPage;
    TablePage tablePage;

    @BeforeMethod
    public void setup(){
        menuPage=new MenuPage(driver);
        tablePage=new TablePage(driver);
        menuPage.openDemoSitesMenu()
                .openTable();
    }

    @Test
    public void createObjectFromTableTest() {
        tablePage.createObjectFromTable()
                .printTableObjects()
                .assertTable();
    }

    @Test
    public void printHeightTest() {
        tablePage.createObjectFromTable()
                .printRandomStructureBuildings();
    }
}
