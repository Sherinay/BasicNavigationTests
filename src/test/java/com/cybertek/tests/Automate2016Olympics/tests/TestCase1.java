package com.cybertek.tests.Automate2016Olympics.tests;

import com.cybertek.tests.Automate2016Olympics.pages.WikipediaMedalTable;
import com.cybertek.utilities.Driver;
import com.cybertek.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class TestCase1 extends TestBase {

    @Test
    public void test1() throws Exception {
        WikipediaMedalTable tablepage = new WikipediaMedalTable();
        /*
        List<WebElement> allRanks = new ArrayList<>();

        for(int i=0; i < tablepage.ranks.size()-2; i++){
            allRanks.add( tablepage.ranks.get(i) );
        }

        System.out.println(allRanks.size());
        */

        List<WebElement> allranks = Driver.get().findElements(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']//tbody//tr//td[1]"));

        Thread.sleep(3000);
        allranks.remove(11);
        allranks.remove(10);
        System.out.println(allranks.size());

        System.out.println("__________________________________________________");

        int i = 1;
        for (WebElement eachrank : allranks) {
            System.out.println(eachrank.getText());
            Assert.assertTrue(eachrank.getText().equals("" + i));
            i++;
        }
        System.out.println("__________________________________________________");

        List<WebElement> allNOC = Driver.get().findElements(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']//tbody//th"));

        System.out.println(allNOC.size());

           allNOC.remove(allNOC.size()-1);
        System.out.println(allNOC.size());
        for (WebElement country : allNOC) {
            System.out.println(country.getText());
        }

//        List<WebElement> countries= new ArrayList<>();
//        String listedCountry = "";
//        for (int j = 0; j < allNOC.size()-1; j++) {
//             countries.add(allNOC.get(j));
//            for (WebElement country : countries) {
//                listedCountry=country.getText();
//            }
//            System.out.println(listedCountry);
//
//        }

        System.out.println("--------------------------------------------------");






        Thread.sleep(5000);
        tablepage.clickNOC();
        Thread.sleep(5000);
        for (WebElement country : allNOC) {
            System.out.println(country.getText());
        }




    }

}
