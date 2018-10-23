import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class AutomationTableTest extends BaseTest {

    @Test
    public void selectWholeTableTest() {
        driver.get("http://toolsqa.com/automation-practice-table/");
        WebElement table = driver.findElement(By.cssSelector("table[class='tsc_table_s13']"));
        List<WebElement> rows = table.findElements(By.cssSelector("tbody tr"));
        System.out.println("number of rows in table: " + rows.size());
        int rowIndex = 1;
        for (WebElement rowElement : rows) {
            List<WebElement> rowElements = rowElement.findElements(By.cssSelector("td"));
            WebElement structureElement=rowElement.findElement(By. cssSelector("th[scope='row']"));
            System.out.println("\n" + "Row " + rowIndex);
            System.out.println(structureElement.getText());
            for (WebElement element : rowElements) {
                System.out.println(element.getText());
            }
            rowIndex += 1;
        }
    }

    @Test
    public void createObjectFromTableTest() {
        driver.get("http://toolsqa.com/automation-practice-table/");
        WebElement table = driver.findElement(By.cssSelector("table[class='tsc_table_s13']"));
        List<WebElement> rowsList = table.findElements(By.cssSelector("tbody tr"));
        // Table object list
        List<Table> tableLists = new ArrayList<Table>();
        for (WebElement rowElement: rowsList) {
            tableLists.add(new Table(rowElement));
        }
        for (Table element:tableLists) {
            element.printTable();
        }
        Assert.assertEquals(tableLists.get(0).getHeight(),829);
        Assert.assertEquals(tableLists.get(1).getRank(),2);
    }

// pomimo,że w innym teście nie występuje, to tutaj jest błąd:
    //Unable to locate element: {"method":"css selector","selector":"table[class='tsc_table_s13']"}
    @Test
    public void printHeightTest() {
        Random random = new Random();
        int low = 400;
        int high = 800;
        int randomHeight = random.nextInt(high - low) + low;
        System.out.println(randomHeight);

        driver.get("http://toolsqa.com/automation-practice-table/");
        WebElement table = driver.findElement(By.cssSelector("table[class='tsc_table_s13']"));
        List<WebElement> rows = table.findElements(By.cssSelector("tbody tr"));
        List<Table> tableLists = new ArrayList<Table>();
        for (WebElement rowElement: rows) {
            tableLists.add(new Table(rowElement));
        }

        for(int i = 0; i < tableLists.size(); i++){
            int height = tableLists.get(i).getHeight();
            if(height > randomHeight){
                System.out.println(tableLists.get(i).getStructure());
            }
        }

    }


    @Test
    public void selectOneCellTest() {
        driver.get("http://toolsqa.com/automation-practice-table/");
        WebElement table = driver.findElement(By.cssSelector("table[class='tsc_table_s13']"));
        List<WebElement> rows = table.findElements(By.cssSelector("tbody tr"));
        for (WebElement rowElement : rows) {
            List<WebElement> singleElements = rowElement.findElements(By.cssSelector("td"));
            for (WebElement element : singleElements) {
                element.getText();
                if (element.getText().equals("Clock Tower Hotel")) {
                    WebElement searchedElement = element.findElement(By.xpath("//th[contains(text(),'Clock Tower Hotel')]"));
                    Assert.assertEquals(searchedElement.getText(),"Clock Tower Hotel");
                }
            }
        }
    }
}
