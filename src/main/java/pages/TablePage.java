package pages;

import model.Table;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class TablePage extends BasePage{

    List<Table> tableLists;

    public TablePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        waitUntilElementsVisible();
    }

    @FindBy(css = "tbody tr")
    private List<WebElement> allRowsOfTable;

    public void waitUntilElementsVisible(){
        waitForElements(allRowsOfTable);
    }

    public void createObjectFromTable() {
        tableLists = new ArrayList<Table>();
        for (WebElement rowElement : allRowsOfTable) {
            tableLists.add(new Table(rowElement));
        }
    }

    public void printTableObjects(){
        createObjectFromTable();
        for (Table element : tableLists) {
            element.printTable();
        }
    }

    public void assertTable(){
        Assert.assertEquals(tableLists.get(0).getHeight(),829);
        Assert.assertEquals(tableLists.get(1).getRank(),2);
    }

    public int randomHeightNumber(){
        Random random = new Random();
        int low = 400;
        int high = 800;
        return random.nextInt(high - low) + low;
    }
    public void printRandomStructureBuildings() {
        System.out.println(randomHeightNumber());
        for (int i = 0; i < tableLists.size(); i++) {
            int height = tableLists.get(i).getHeight();
            if (height > randomHeightNumber()) {
                System.out.println(tableLists.get(i).getStructure());
            }
        }
    }


}
