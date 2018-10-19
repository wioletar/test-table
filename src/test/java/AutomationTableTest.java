import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;


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
            System.out.println("\n" + "Row " + rowIndex);

            for (WebElement colElement : rowElements) {
                System.out.println(colElement.getText());

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
        Assert.assertEquals(tableLists.get(0).getHeight(),"829m");
        Assert.assertEquals(tableLists.get(1).getRank(),2);
    }

    // nie wiem dlaczego nie wypisuje tej komórki z tabeli
    @Test
    public void selectOneCellTest() {
        driver.get("http://toolsqa.com/automation-practice-table/");

        WebElement table = driver.findElement(By.cssSelector("table[class='tsc_table_s13']"));
        List<WebElement> rows = table.findElements(By.cssSelector("tbody tr"));
        System.out.println("number of rows in table: " + rows.size());

        for (WebElement rowElement : rows) {
            List<WebElement> singleElements = rowElement.findElements(By.cssSelector("td"));
            for (WebElement element : singleElements) {
                element.getText();
                if (element.getText().equals("Clock Tower Hotel")) {
                    WebElement searchedElement = element.findElement(By.xpath("//th[contains(text(),'Clock Tower Hotel')]"));
                    System.out.println(searchedElement.getText());
                }
            }
        }
    }
}
