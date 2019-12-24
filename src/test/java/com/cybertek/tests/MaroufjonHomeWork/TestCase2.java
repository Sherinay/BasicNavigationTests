package com.cybertek.tests.MaroufjonHomeWork;

import com.cybertek.utilities.BrowserFactory;
import com.cybertek.utilities.StringUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestCase2 {
    /*
    go to amazon
        Go to ebay
        enter search term
        click on search button
        verify title contains search term
     */
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://amazon.com");
        Thread.sleep(500);
        driver.navigate().to("http://ebay.com");
        WebElement searchBox=driver.findElement(By.id("gh-ac"));
        searchBox.sendKeys("term");
        searchBox.submit();
        boolean result= StringUtility.verifyContains(driver.getTitle(),"term");
        System.out.println(result);
        driver.quit();


    }
}
