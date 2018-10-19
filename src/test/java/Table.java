import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Table {

    private String structure;
    private String country;
    private String city;
    private String height;
    private int built;
    private int rank;


    public Table() {
    }

    public Table(WebElement tr) {
        this.structure = tr.findElement(By.cssSelector("th")).getText();
        List<WebElement> tds = tr.findElements(By.cssSelector("td"));
        this.country = tds.get(0).getText();
        this.city = tds.get(1).getText();
        this.height = tds.get(2).getText();
        this.built = Integer.parseInt(tds.get(3).getText());
        this.rank = Integer.parseInt(tds.get(4).getText());
    }

    public void printTable(){
        System.out.println(structure+" "+country+" "+city+" "+height+" "+built+" "+rank);
    }
    public String getStructure() {
        return structure;
    }

    public void setStructure(String structure) {
        this.structure = structure;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public int getBuilt() {
        return built;
    }

    public void setBuilt(int built) {
        this.built = built;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}
