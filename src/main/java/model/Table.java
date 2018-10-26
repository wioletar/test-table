package model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Table {

    private String structure;
    private String country;
    private String city;
    private int height;
    private int built;
    private int rank;



    public Table(WebElement rowElements) {
        this.structure = rowElements.findElement(By.cssSelector("th")).getText();
        List<WebElement> rowElementsTd = rowElements.findElements(By.cssSelector("td"));
        this.country = rowElementsTd.get(0).getText();
        this.city = rowElementsTd.get(1).getText();
        this.height = Integer.parseInt(rowElementsTd.get(2).getText().substring(0,3));
        this.built = Integer.parseInt(rowElementsTd.get(3).getText());
        this.rank = Integer.parseInt(rowElementsTd.get(4).getText());
    }

    public void printTable(){
        System.out.println(structure+", "+country+", "+city+", "+height+", "+built+", "+rank);
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

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
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
