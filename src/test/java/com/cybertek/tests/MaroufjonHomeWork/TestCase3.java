package com.cybertek.tests.MaroufjonHomeWork;

import com.cybertek.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestCase3 {
    /*
    Go to wikipedia.org (Links to an external site.)
enter search term `selenium webdriver`
click on search button
click on search result `Selenium (software)`
verify url ends with `Selenium_(software)`
     */
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://wikipedia.org");
        WebElement SearchBox=driver.findElement(By.id("searchInput"));
        SearchBox.sendKeys("selenium webdriver");
        WebElement SearchBtn=driver.findElement(By.xpath("//*[@id=\"search-form\"]/fieldset/button"));
        SearchBtn.click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div[3]/ul/li[1]/div[1]/a")).click();
        Thread.sleep(500);
        boolean result=driver.getCurrentUrl().endsWith("Selenium_(software)");
        System.out.println(result);
        driver.quit();


    }
}
