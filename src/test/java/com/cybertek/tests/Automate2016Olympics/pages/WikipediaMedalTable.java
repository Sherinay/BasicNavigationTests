package com.cybertek.tests.Automate2016Olympics.pages;

import com.cybertek.utilities.Driver;
import com.cybertek.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.*;

public class WikipediaMedalTable extends TestBase {
    Driver driver;

    public WikipediaMedalTable() {
        PageFactory.initElements(Driver.get(), this);        //Driver is calling driver from Singleton class
    }

    @FindBy(how = How.XPATH, using = "//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']//tbody//tr//td[1]")
    public List<WebElement> ranks;

    @FindBy(how = How.XPATH, using = "//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']//tbody//th")
    public List<WebElement> nOCTable;

    @FindBy(how = How.XPATH, using = "//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']//thead//th[2]")
    public WebElement nocHeader;

    public void rankVerify() {
        for (int i = 1; i < 11; i++) {
            String xp = "//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']//tbody//tr[1]//td[1]";
            WebElement rankelemnt = Driver.get().findElement(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']//tbody//tr[" + i + "]//td[1]"));
            System.out.println(rankelemnt.getText());
        }
    }

    public void clickNOC(){
        nocHeader.click();
    }

}








