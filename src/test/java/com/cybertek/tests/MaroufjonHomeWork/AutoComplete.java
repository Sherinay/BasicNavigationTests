package com.cybertek.tests.MaroufjonHomeWork;

import com.cybertek.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AutoComplete {
    @Test
    public void test(){
        WebDriver driver= BrowserFactory.getDriver("firefox");
        driver.manage().window().maximize();
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.linkText("Autocomplete")).click();
        driver.findElement(By.id("myCountry")).sendKeys("United States of America");
        driver.findElement(By.xpath("//input[@type='button']")).click();
        String msg=driver.findElement(By.xpath("//p[@id='result']")).getText();
        Assert.assertEquals(msg,"You selected: United States of America");
        driver.quit();
    }
}
