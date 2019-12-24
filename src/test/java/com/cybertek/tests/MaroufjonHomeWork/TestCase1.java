package com.cybertek.tests.MaroufjonHomeWork;

import com.cybertek.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestCase1 {
    /*
    Go to ebay
        enter search term
        click on search button
        print number of results
     */
    public static void main(String[] args) {
        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://ebay.com");
        WebElement searchBox=driver.findElement(By.id("gh-ac"));
        searchBox.sendKeys("term");
        searchBox.submit();
        String searchResult=driver.findElement(By.className("srp-controls__count-heading")).getText().split(" ")[0];
        System.out.println(searchResult);
        driver.quit();


    }
}
