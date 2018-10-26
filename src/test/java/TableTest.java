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
    }

    @Test
    public void createObjectFromTableTest() {
        menuPage.openDemoSitesMenu();
        menuPage.openTable();
        tablePage.createObjectFromTable();
        tablePage.printTableObjects();
        tablePage.assertTable();
    }

    @Test
    public void printHeightTest() {
        menuPage.openDemoSitesMenu();
        menuPage.openTable();
        tablePage.createObjectFromTable();
        tablePage.randomHeightNumber();
        tablePage.printRandomStructureBuildings();

    }
}
