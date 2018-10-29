package pages;

import model.Table;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TablePage extends BasePage{

    List<Table> tableLists;

    public TablePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "tbody tr")
    private List<WebElement> allRowsOfTable;

    public TablePage createObjectFromTable() {
        tableLists = new ArrayList<Table>();
        for (WebElement rowElement : allRowsOfTable) {
            tableLists.add(new Table(rowElement));
        }
        return this;
    }

    public TablePage printTableObjects(){
        createObjectFromTable();
        for (Table element : tableLists) {
            element.printTable();
        }
        return this;
    }

    public void assertTable(){
        waitForElements(allRowsOfTable);
        createObjectFromTable();
        Assert.assertEquals(tableLists.get(0).getHeight(),829);
        Assert.assertEquals(tableLists.get(1).getRank(),2);
    }

    public int randomHeightNumber(){
        Random random = new Random();
        int low = 400;
        int high = 800;
        return random.nextInt(high - low) + low;
    }
    public TablePage printRandomStructureBuildings() {
        System.out.println(randomHeightNumber());
        for (int i = 0; i < tableLists.size(); i++) {
            int height = tableLists.get(i).getHeight();
            if (height > randomHeightNumber()) {
                System.out.println(tableLists.get(i).getStructure());
            }
        }
        return this;
    }
}
